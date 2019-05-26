package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import redis.RedisUtil;
import service.RmiChoose;
import service.UserService;
import util.CheckUtil;
import util.MD5Utils;

@Controller
public class RegisterController {
    Logger logger = Logger.getLogger(RegisterController.class);
//    @Autowired
//    UserService us;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    RmiChoose rc;

    @RequestMapping(value = "/a/register",method = RequestMethod.GET)
    public String registerView(){
        return "register";
    }

    @RequestMapping(value = "/a/register", method = RequestMethod.POST)
    public ModelAndView register(String username, String password,String mobileOrEmail,String code) {
        ModelAndView mav = new ModelAndView();

        logger.info("#"+username);
        logger.info("#"+password);
        logger.info("#"+mobileOrEmail);
        logger.info("#"+code);
        try {
            //查看验证码是否正确
            String codeKey = mobileOrEmail + "tactics";
            String codeInRedis= (String) redisUtil.get(codeKey);
            if (!code.equals(codeInRedis)) {
                mav.addObject("code", -1);
                mav.addObject("msg", "验证码错误");
                mav.addObject("mobileOrEmail", mobileOrEmail);
                mav.setViewName("register");
                return mav;
            }

            //校验账号密码不为空
            if (null == username || "".equals(username) || null == password || "".equals(password)) {
                mav.addObject("code", -1);
                mav.addObject("msg", "账号密码不能为空");
                mav.addObject("mobileOrEmail", mobileOrEmail);
                mav.setViewName("register");
                return mav;
            }

            //判断是否是手机或者邮箱格式
            if (!CheckUtil.isMobileNO(mobileOrEmail) && !CheckUtil.isEmail(mobileOrEmail)) {
                logger.info("#既不符合邮箱格式也不符合手机格式");
                mav.addObject("code", -1);
                mav.addObject("msg", "请输入正确的邮箱或手机号");
                mav.setViewName("code");
                return mav;
            }

            //创建mobile和email，默认为null
            String mobile = null;
            String email = null;
            User userInDB = new User();
            //判断是手机号
            if (CheckUtil.isMobileNO(mobileOrEmail)) {
                //如果是手机号转成Long包装类
                mobile = mobileOrEmail;
                }
            //判断是邮箱
            if (CheckUtil.isEmail(mobileOrEmail)) {
                email = mobileOrEmail;
                }


            //查询
            userInDB = rc.getUserService().getByMobil(mobile,email);

//        String passwdInDb=userInDB.getPassword();
//            logger.info("[logger]查询用户"+userInDB);
//
//            logger.info("[logger]查询出密码是否存在="+userInDB);

            if (null != userInDB) {
                mav.addObject("msg", "账号重复");
                mav.setViewName("code");
                return mav;
            }

            //MD5加密密码
            String passwordMD5 = MD5Utils.getSaltMD5(password);
            logger.info("[logger]获得md5加密密码="+passwordMD5);
            User user = new User();
            user.setMobil(mobile);
            user.setEmail(email);
            user.setPassword(passwordMD5);
            user.setName(username);
            rc.getUserService().insertSelective(user);
            mav.addObject("msg", "注册成功,请登录！");
            mav.addObject("mobileOrEmail",mobileOrEmail);
            mav.addObject("password", password);
//            mav.addObject("passwordMD5", passwordMD5);
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
}
