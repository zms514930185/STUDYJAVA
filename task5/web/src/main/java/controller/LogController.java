package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserService;
import util.CookieUtils;
import util.JWTUtils;
import util.MD5Utils;
import util.NumCheck;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LogController {

    @Autowired
    private UserService us;

    Logger logger = Logger.getLogger(LogController.class);

    @RequestMapping(value = "/a/login",method = RequestMethod.GET)
    public String loginView(){
        return "login";
    }

    @RequestMapping(value = "/a/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, HttpServletRequest req, HttpServletResponse resp)  {

        ModelAndView mav = new ModelAndView();
        try {
        if (null == username || "".equals(username) || null == password || "".equals(password)) {
            mav.addObject("code",-1);
            mav.addObject("msg","账号或密码不能为空");
            mav.setViewName("login");
            return mav;
        }

        Long mobil=Long.valueOf(username);
        logger.info("[logger]mobil转换格式mobil="+mobil);
        User userInDB = us.getByMobil(mobil);
        logger.info("[logger]获得对应user="+userInDB);

        if (null == userInDB) {
            mav.addObject("code",-1);
            mav.addObject("msg","账号不存在,请先注册账号");
            mav.setViewName("register");
            return mav;
        }

        String passwdInDb=userInDB.getPassword();
        String id=userInDB.getId().toString();
        logger.info("[logger]查询用户密码"+passwdInDb);
        logger.info("[logger]查询用户"+userInDB.getName());

        boolean pass= MD5Utils.verifyPwd(password,passwdInDb);
        if (pass){
            //生成token
            String token = JWTUtils.createJWT(id, "task5_test", username,  3600 * 1000);
            //创建Cookie
            CookieUtils.createCookie(resp, "token", token,  3600, null);
            String name=userInDB.getName();
            mav.addObject("name",name);
            mav.addObject("code",200);
            mav.addObject("msg","登陆成功");
            mav.setViewName("vip");
            return mav;
        }
        mav.addObject("code",-1);
        mav.addObject("msg","账号密码错误");
        mav.setViewName("login");
        return mav;
        }catch (Exception e){
            System.err.println(e);
            mav.addObject("code", -1);
            mav.addObject("msg", "error");
            mav.setViewName("login");
            return mav;
        }

    }

    @RequestMapping(value = "/a/register",method = RequestMethod.GET)
    public String registerView(){
        return "register";
    }

    @RequestMapping(value = "/a/register", method = RequestMethod.POST)
    public ModelAndView register(String username,String password) {

        ModelAndView mav = new ModelAndView();
        try {
            logger.info("[logger]判空判null");
        if (null == username || "".equals(username) || null == password || "".equals(password)) {
            mav.addObject("code", -1);
            mav.addObject("msg", "不能为空");
            mav.setViewName("register");
            return mav;
        }
            logger.info("[logger]校验手机号");
        if (username.length() != 11 || !NumCheck.checkNumber(username)) {
                mav.addObject("code", -1);
                mav.addObject("msg", "手机号不正确");
                mav.setViewName("register");
                return mav;
         }

        Long mobil = Long.valueOf(username);
        logger.info("[logger]将string转成long="+mobil);

        User userInDB = us.getByMobil(mobil);
//        String passwdInDb=userInDB.getPassword();
        logger.info("[logger]查询用户"+userInDB);

        logger.info("[logger]查询出密码是否存在="+userInDB);

        if (null != userInDB) {
            mav.addObject("msg", "账号重复");
            mav.setViewName("register");
            return mav;
        }


            String passwordMD5 = MD5Utils.getSaltMD5(password);
            logger.info("[logger]获得md5加密密码="+passwordMD5);
            User user = new User();
            user.setMobil(mobil);
            user.setPassword(passwordMD5);
            user.setName("用户"+username);
            us.insertSelective(user);
            mav.addObject("msg", "注册成功,请登录！");
            mav.addObject("passwordMD5", passwordMD5);
            mav.setViewName("login");
            return mav;
        } catch (Exception e) {
            System.err.println(e);
            mav.addObject("code", -1);
            mav.addObject("msg", "error");
            mav.setViewName("register");
            return mav;
        }
    }

    @RequestMapping(value = "/a/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest req,HttpServletResponse resp,String cookieName){
        cookieName="token";
        CookieUtils.delCookie(req,resp,cookieName);
        logger.info("[logger]删除cookie");
        HttpSession session = req.getSession();
        session.invalidate();
        return "redirect:/";
    }


    @RequestMapping(value = "/a/u/vip",method = RequestMethod.GET)
    public ModelAndView vipView(){
        return new ModelAndView("vip");
    }

}
