package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Job;
import pojo.JobExample;
import service.JobService;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService js;

    @RequestMapping(value = "/job", method = RequestMethod.GET)
    public ModelAndView showJob() {
        JobExample e1 = new JobExample();
        JobExample.Criteria c1 = e1.createCriteria();
        c1.andDirectionEqualTo("前端开发方向");
        List<Job> front =js.selectByExample(e1);

        JobExample e2 = new JobExample();
        JobExample.Criteria c2 = e2.createCriteria();
        c2.andDirectionEqualTo("后端开发方向");
        List<Job> behind =js.selectByExample(e2);

        JobExample e3 = new JobExample();
        JobExample.Criteria c3 = e3.createCriteria();
        c3.andDirectionEqualTo("运维方向");
        List<Job> maintain =js.selectByExample(e3);


        JobExample e4 = new JobExample();
        JobExample.Criteria c4 = e4.createCriteria();
        c4.andDirectionEqualTo("用户体验方向");
        List<Job> user =js.selectByExample(e4);


        ModelAndView mav = new ModelAndView("job");
        mav.addObject("front", front);
        mav.addObject("behind", behind);
        mav.addObject("maintain", maintain);
        mav.addObject("user", user);
        return mav;
    }
}
