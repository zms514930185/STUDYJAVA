package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Student;
import service.StuService;

@Controller
public class UpdateController {
    @Autowired
    StuService stuService;

    @RequestMapping(value = "update")
    public ModelAndView update(Student stu) {
        stuService.update(stu);
        ModelAndView mav = new ModelAndView("redirect:/");
        return mav;
    }

    @RequestMapping("edit")
    public ModelAndView edit(Student stu) {
        Student student = stuService.select(stu.getId());
        ModelAndView mav = new ModelAndView();
        mav.addObject("s", student);
        mav.setViewName("update");
        return mav;
    }
}