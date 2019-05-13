package interceptor;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pojo.User;
import service.UserService;
import util.CookieUtils;
import util.JWTResult;
import util.JWTUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Autowired
    UserService userService;
    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        logger.info("[logger]启动拦截器");
        Cookie[] cookies= CookieUtils.getCookie(request);
        logger.info("[logger]获取cookies\t"+cookies);
        if (null == cookies) {
            response.sendRedirect("/");
            return false;
        }
        logger.info("[logger]有Cookie");
        for (Cookie cookie : cookies) {
            logger.info("[logger]遍历cookie\t"+cookie);
            String cookieName=cookie.getName();
            logger.info("[logger]cookiem名\t"+cookieName);
            String token=cookie.getValue();
            logger.info("[logger]value名\t"+cookie);
            logger.info("[logger]遍历完成：\t"+cookieName+"\t"+token);
            if ("token".equals(cookieName)) {

                logger.info("[logger]存在token");
                JWTResult result= JWTUtils.validateJWT(token);

                if (!result.isSuccess()){
                    logger.info("[logger]token状态\t"+result.isSuccess());
                    response.sendRedirect("/");
                    return false;
                }

                Claims claims=result.getClaims();
                logger.info("[logger]获取claims");

                Long id=Long.valueOf(claims.getId());
                String username=claims.getSubject();
                logger.info("[logger]id=\t"+id);
                logger.info("[logger]username=\t"+username);

                User user = userService.selectByPrimaryKey(id);
                logger.info("[logger]执行查询"+user);
                String pwd=user.getPassword();
                logger.info("[logger]获取密码"+pwd);
                if (null !=pwd) {
//                        Date lag = new Date(System.currentTimeMillis()+50000L);
//                        claims.setExpiration(lag);
                    String newToken=JWTUtils.createJWT(claims.getId(),
                            claims.getIssuer(),claims.getSubject(),60*60*1000);
                    logger.info("[logger]新token="+newToken);
                    cookie.setValue(newToken);
//                        cookie.setValue(token);
//                        CookieUtils.createCookie(response,cookie.getName(),newToken,cookie.getMaxAge(),cookie.getPath());
                    return true;
                }
            }
        }

        System.out.println("preHandle(), 在访问Controller之前被调用");
        response.sendRedirect("/a/login");
        return false;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle(), 在访问Controller之后，访问视图之前被调用,这里可以注入一个时间到modelAndView中，用于后续视图显示");
//        modelAndView.addObject("date","由拦截器生成的时间:" + new Date());
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        System.out.println("afterCompletion(), 在访问视图之后被调用");
    }

}