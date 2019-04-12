package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import pojo.Student;
import service.StuService;

@Controller
public class addController {
  private   Logger logger=Logger.getLogger(addController.class);
    @Autowired
    StuService stuService;

    @RequestMapping(value = "add")
    public ModelAndView add(Student stu) {
        logger.info(stu.toString());
        ModelAndView mav = new ModelAndView();
        stuService.addStu(stu);
        mav.addObject("code", 1000);
        mav.addObject("msg", "添加成功");
        mav.setViewName("redirect:/");
        return mav;
    }
}
