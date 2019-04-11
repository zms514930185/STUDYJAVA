package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import pojo.Student;
import service.StuService;
import util.Page;

import java.util.List;

@Controller
public class ShowController {
    @Autowired
    StuService stuService;

    @RequestMapping(value = "/" )
    public ModelAndView list(Page page){
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Student> list = stuService.list();

        int total = (int) new PageInfo<>(list).getTotal();
        page.calculateLast(total);
        mav.addObject("list", list);
        mav.setViewName("stulist");
        return mav;
    }
}
