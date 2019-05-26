package exception;

import com.aliyuncs.exceptions.ClientException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.IOException;

@ControllerAdvice
public class GlobalException {

    Logger logger = Logger.getLogger(GlobalException.class);
    @ExceptionHandler(ClientException.class)
    public ModelAndView codeError(Exception e){
        logger.info("#ClientException==>"+e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "发送请求异常");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @ExceptionHandler(IOException.class)
    public ModelAndView ioError(Exception e) {
        logger.info("#IOException==>"+e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "输入异常");
        return mav;
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView error(Exception e) {
        logger.info("#RuntimeException==>"+e);
        ModelAndView mav = new ModelAndView("code");
        mav.addObject("msg", "发送请求异常");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }
}
