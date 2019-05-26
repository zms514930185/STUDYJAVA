package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class CookieUtils {

    /**
     * 生成cookie
     *
     * @param resp
     * @param cookieName
     * @param cookieValue
     * @param sec
     * @param pathUrl
     */
    public static void createCookie(HttpServletResponse resp, String cookieName, String cookieValue, int sec, String pathUrl) {
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");


        //响应处理结果
        //使用Cookie进行浏览器端的数据存储
        //创建Cookie对象
        Cookie cookie = new Cookie(cookieName, cookieValue);

        //设置Cookie
        //设置Cookie的有效期
        cookie.setMaxAge(sec);
        //设置有效路径
        cookie.setPath(pathUrl);

        //响应Cookie信息
        resp.addCookie(cookie);

    }

    /**
     * 获取cookie
     *
     * @param req
     * @throws UnsupportedEncodingException
     */
    public static Cookie[] getCookie(HttpServletRequest req) throws UnsupportedEncodingException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //获取请求信息
        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                String cookieName = cookie.getName();
//                String cookieValue = cookie.getValue();
//                if(cookieName.equals("token")){
//                    return cookie;
//                }
//                else {
//                    return null;
//                }
//            }
//        }
//        return null;
        return cookies;
    }


    /**
     * 删除cookie
     *
     * @param req
     * @param resp
     * @param cookieName
     */
    public static void delCookie(HttpServletRequest req, HttpServletResponse resp, String cookieName) {
        cookieName="token";
        Cookie[] cookies = req.getCookies();
        if (null == cookies) {
            System.out.println("没有cookie==============");
        } else {
            Cookie newCookie=null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    newCookie=new Cookie("token",cookie.getValue());
                }
            }
            newCookie.setMaxAge(0);// 立即销毁cookie
            newCookie.setPath(null);
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.addCookie(newCookie);
        }
    }
}
