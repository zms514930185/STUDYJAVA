package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {
    public static boolean checkNumber(double value){
        String str = String.valueOf(value);
        String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
        return str.matches(regex);
    }

    public static boolean checkNumber(int value){
        String str = String.valueOf(value);
        String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
        return str.matches(regex);
    }

    public static boolean checkNumber(String value){
        String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
        return value.matches(regex);
    }


//        System.out.println(checkNumber(0));// true
//        System.out.println(checkNumber(-0));// true
//        System.out.println(checkNumber(23));// true
//        System.out.println(checkNumber(-23));// true
//        System.out.println(checkNumber(0.0));// true
//        System.out.println(checkNumber(-0.0));// true
//        System.out.println(checkNumber(23.01));// true
//        System.out.println(checkNumber(-23.01));// true
//        System.out.println(checkNumber("-10.01.01"));// false
//        System.out.println(checkNumber("A110"));// false

    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        boolean flag = false;
        try{
            String check="^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$";
            Pattern regex = Pattern.compile(check);
            Matcher m = regex .matcher(mobiles);
            flag = m.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }


    /**
     * 验证邮箱地址是否正确
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }


}
