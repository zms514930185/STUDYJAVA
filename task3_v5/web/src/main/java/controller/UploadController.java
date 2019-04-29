package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import util.UploadedImageFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class UploadController {
    Logger logger = Logger.getLogger(UploadController.class);
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) {
       try {

           logger.info("[logger]"+file.getImage().getOriginalFilename());

           String newFileName=file.getImage().getOriginalFilename();
           logger.info("[logger]"+newFileName);

           //        固定地址
           String path = "/Users/chen/Desktop/image";
           //        File newFile = new File(path, newFileName);
           //        工程webapp下地址
           File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);

           logger.info("[logger]get newFile");
           newFile.getParentFile().mkdirs();
           file.getImage().transferTo(newFile);
           logger.info("[logger]transfer success");

           ModelAndView mav = new ModelAndView();
           mav.addObject("imageName", newFileName);
           logger.info("[logger] add imagename success");
           mav.addObject("imageUrl","/image");
           mav.setViewName("show");

//        mav.setView(new MappingJackson2JsonView());
           logger.info("[logger] setview success");
           return mav;
       }catch (Exception e){
           e.printStackTrace();
           return new ModelAndView();
       }
    }
}
