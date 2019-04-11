package controller;

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
    @Autowired
    StuService stuService;
    @RequestMapping(value = "add")
    public ModelAndView add(Student stu){
        ModelAndView mav = new ModelAndView("redirect:/");
        stuService.addStu(stu);
        return mav;
    }
}
