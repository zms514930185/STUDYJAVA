package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import util.ali.AliOssUtil;

import java.io.IOException;

@Controller
public class UploadController {
    Logger logger = Logger.getLogger(UploadController.class);
    @Autowired
    AliOssUtil aliOss;

    @RequestMapping(value = "/a/u/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        logger.info(file.getName());
        ModelAndView mav = new ModelAndView();
        String urlPath = aliOss.upLoad(file);
        mav.addObject("urlPath", urlPath);
        mav.setViewName("vip");
        return mav;
    }
}
