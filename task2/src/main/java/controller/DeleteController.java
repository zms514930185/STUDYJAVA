package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import pojo.Student;
import service.StuService;

@Controller
public class DeleteController {
    @Autowired
    StuService stuService;
    @RequestMapping("delete")
    public ModelAndView delete(Student stu){
        stuService.delete(stu);
        ModelAndView mav = new ModelAndView("redirect:/");
        mav.addObject("code", 0);
        mav.addObject("msg", "删除成功");
        return mav;
    }
}
