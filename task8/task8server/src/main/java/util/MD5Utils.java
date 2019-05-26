package util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Random;


public class MD5Utils {
    /**
     * 使用Apache的Hex类实现Hex(16进制字符串和)和字节数组的互转
     * <p>
     *
     * @Title : md5Hex
     */
    @SuppressWarnings("unused")
    private static String md5Hex(String str) {
        try {
            //获取md实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            //生成摘要
            byte[] digest = md.digest(str.getBytes());
            return new String(new Hex().encode(digest));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.toString());
            return "";
        }
    }
    /**
     * 加盐MD5加密
     * <p>
     *
     * @Title : getSaltMD5
     */
    public static String getSaltMD5(String password) {
        // 生成一个16位的随机数
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(16);
        sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
        int len = sBuilder.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sBuilder.append("0");
            }
        }
        // 生成最终的加密盐
        String Salt = sBuilder.toString();

        password = md5Hex(password + Salt);
        char[] cs = new char[48];

        for (int i = 0; i < 48; i += 3) {
            //password 0.2.4.6.8.10
            cs[i] = password.charAt(i / 3 * 2);
            //salt 0.1.3.5.7.9
            char c = Salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }

    /**
     * 验证加盐后是否和原文一致
     * <p>
     *
     * @Title : verifyMD5
     */
    public static boolean verifyPwd(String password, String md5pwd) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            //cs1[]  0.2.4.6.8 .10
            //md5pwd 0.3.6.9.12.15
            cs1[i / 3 * 2] = md5pwd.charAt(i);
            //salt[] 0.1.2.3 .4 .5
            //md5pwd 1.4.7.10.13.16
            cs2[i / 3] = md5pwd.charAt(i + 1);
            //cs1[]  1.3.5.7 .9 .11
            //md5pwd 2.5.7.11.14.17
            cs1[i / 3 * 2 + 1] = md5pwd.charAt(i + 2);
        }
        String Salt = new String(cs2);
//        System.out.println("[logger]salt="+Salt);
//        System.out.println("[logger]"+md5pwd);
        return md5Hex(password + Salt).equals(String.valueOf(cs1));
    }
}
