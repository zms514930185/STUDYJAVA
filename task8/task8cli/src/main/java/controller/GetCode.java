package controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import redis.RedisUtil;
import util.CheckUtil;
import util.ali.AliEmailUtil;
import util.ali.AliSmsUtil;
import util.ali.NumRandom;


@Controller
public class GetCode {
    Logger logger = Logger.getLogger(GetCode.class);

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    NumRandom numRandom;
    @Autowired
    AliSmsUtil aliSmsUtil;
    @Autowired
    AliEmailUtil aliEmailUtil;

    @RequestMapping("/a/code")
    public String getCodeView(){
        return "code";}

    @RequestMapping(value = "/a/code", method = RequestMethod.POST)
    public ModelAndView getCode(@RequestParam(value = "mobilOrEmail") String mobileOrEmail) throws ClientException {
        ModelAndView mav = new ModelAndView();

        //判断是否是手机或者邮箱格式
        if (!CheckUtil.isMobileNO(mobileOrEmail) && !CheckUtil.isEmail(mobileOrEmail)) {
            logger.info("#既不符合邮箱格式也不符合手机格式");
            mav.addObject("code", -1);
            mav.addObject("msg", "输入格式不正确");
            mav.setViewName("code");
            return mav;
        }

        //上次发送时间
        long lastSendTime = 0;
        //发送次数
        int sendCount = 0;

        if (null != redisUtil.hget(mobileOrEmail, "lastSendTime")) {
            //如果redis中存在上次发送时间，获取上次发送时间
            lastSendTime = (long) redisUtil.hget(mobileOrEmail, "lastSendTime");
            //如果redis中存在上次发送时间，获取发送次数
            sendCount = (int) redisUtil.hget(mobileOrEmail, "sendCount");
        }

        logger.info("#缓存发送时间" + lastSendTime);
        logger.info("#缓存发送次数" + sendCount);
        long now = System.currentTimeMillis();

        //判断发送次数
        if (3 <= sendCount) {
            logger.info("#已打今日发送上限！发送次数==>" + sendCount);
            mav.addObject("msg", "以达今日发送上限");
            mav.setViewName("code");
            return mav;
        }
        //判断时间是否小于60秒
        if ((now - lastSendTime) < 1000 * 60) {
            logger.info("#距下次发送验证码还有" + (60 - (now - lastSendTime) / 1000) + "秒");
            String msg = "距下次发送验证码还有" + (60 - (now - lastSendTime) / 1000) + "秒";
            mav.addObject("msg", msg);
            mav.addObject("time", (now - lastSendTime) / 1000);
            mav.setViewName("code");
            return mav;
        }

        //生成6位随机验证码
        String code = numRandom.randNum();
        logger.info("#code==>" + code);

        //创建mobile和email，默认为null
        String mobile = null;
        String email = null;
        if (CheckUtil.isMobileNO(mobileOrEmail)) {
            mobile = mobileOrEmail;
        }
        if (CheckUtil.isEmail(mobileOrEmail)) {
            email = mobileOrEmail;
        }

        SendSmsResponse sendSmsResponse=null;
        if (null != mobile) {
            //发送code到指定mobile号码
            sendSmsResponse = aliSmsUtil.sendSms(mobile, code);
            //判断是否成功发送
        }

        boolean isSend=false;
        //判断邮件是否发送成功
        if (null != email) {
            //发送code到指定邮箱
            String htmlBody="您的验证码是："+code;
            if (aliEmailUtil.sendEmail(email, htmlBody)) {
                isSend=true;
            }
            }
        //邮件或短信发送成功
        if (isSend||aliSmsUtil.isSend(sendSmsResponse)) {
            //存放本次发送成功时间戳
            redisUtil.hset(mobileOrEmail, "lastSendTime", now);
            //存放本次发送次数
            redisUtil.hset(mobileOrEmail, "sendCount", sendCount + 1);
            logger.info("#策略现存有效期==>" + redisUtil.getExpire(mobileOrEmail));
            if (0 >= redisUtil.getExpire(mobileOrEmail)) {
                redisUtil.expire(mobileOrEmail, 24 * 3600);
                logger.info("#策略更新有效期==>" + redisUtil.getExpire(mobileOrEmail));
            }
            //有效期设置
            //code存放key
            String codeKey = mobileOrEmail + "tactics";

            logger.info("#code现存有效期==>" + redisUtil.getExpire(codeKey));
            redisUtil.set(codeKey, code, 30 * 60);
            logger.info("#code更新有效期==>" + redisUtil.getExpire(codeKey));
            logger.info("#设置redis成功==>");
            logger.info("==>" + redisUtil.get(codeKey));
            mav.addObject("msg", "发送成功");
            mav.addObject("mobileOrEmail", mobileOrEmail);
            mav.setViewName("register");
            return mav;
        }
        mav.addObject("msg", "发送失败");
        mav.setViewName("code");
        return mav;
        }
    }
