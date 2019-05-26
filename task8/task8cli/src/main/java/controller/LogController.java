package controller;

import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.RmiChoose;
import service.UserService;
import util.CheckUtil;
import util.CookieUtils;
import util.JWTUtils;
import util.MD5Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LogController {

//    @Autowired
//    private UserService us;
    @Autowired
    RmiChoose rc;

    Logger logger = Logger.getLogger(LogController.class);

    @RequestMapping(value = "/a/login",method = RequestMethod.GET)
    public String loginView(){
        return "login";
    }

    @RequestMapping(value = "/a/login", method = RequestMethod.POST)
    public ModelAndView login(String mobileOrEmail, String password, HttpServletRequest req, HttpServletResponse resp)  {

        ModelAndView mav = new ModelAndView();
        try {
            //判断是否是手机或者邮箱格式
            if (!CheckUtil.isMobileNO(mobileOrEmail) && !CheckUtil.isEmail(mobileOrEmail)) {
                mav.addObject("code", -1);
                mav.addObject("msg", "请输入正确的邮箱或手机号");
                mav.setViewName("code");
                return mav;
            }

            String mobile = null;
            String email = null;
            if (CheckUtil.isEmail(mobileOrEmail)) {
                email = mobileOrEmail;
            }
            if (CheckUtil.isMobileNO(mobileOrEmail)) {
                mobile = mobileOrEmail;
            }

        //查询账号是否存在
        User userInDB = rc.getUserService().getByMobil(mobile,email);
        logger.info("[logger]获得对应user="+userInDB);

        if (null == userInDB) {
            mav.addObject("code",-1);
            mav.addObject("msg","账号不存在,请先注册账号");
            mav.setViewName("login");
            return mav;
        }

        String passwdInDb=userInDB.getPassword();
        String id=userInDB.getId().toString();
        logger.info("[logger]查询用户密码"+passwdInDb);
        logger.info("[logger]查询用户"+userInDB.getName());

        boolean pass= MD5Utils.verifyPwd(password,passwdInDb);
        if (pass){
            //生成token
            String token = JWTUtils.createJWT(id, "task5_test", mobileOrEmail,  3600 * 1000);
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



    @RequestMapping(value = "/a/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse resp, String cookieName){
        cookieName="token";
        CookieUtils.delCookie(req,resp,cookieName);
        logger.info("[logger]删除cookie");
        HttpSession session = req.getSession();
        session.invalidate();
        return "redirect:/";
    }


    @RequestMapping(value = "/a/u/vip",method = RequestMethod.GET)
    public ModelAndView vipView(HttpServletRequest req){
        try {
            ModelAndView mav = new ModelAndView();
            Cookie[] cookies= CookieUtils.getCookie(req);
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token=cookie.getValue();
                    Claims claims = JWTUtils.parseJWT(token);
                    Long id = Long.valueOf(claims.getId());
                    User user = rc.getUserService().selectByPrimaryKey(id);
                    String name = user.getName();
                    mav.addObject("name",name);
                    mav.setViewName("vip");
                    return mav;
                }
            }
            String name="未知用户";
            mav.addObject("name",name);
            return new ModelAndView("vip");
        } catch (Exception e) {
            return new ModelAndView("redirect:/a/login");
        }
        }

}
