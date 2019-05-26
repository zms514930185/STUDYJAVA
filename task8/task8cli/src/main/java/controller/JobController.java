package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Job;
import pojo.JobExample;
import service.JobService;
import service.RmiChoose;
import service.UserService;

import java.util.List;

@Controller
public class JobController {
//    @Autowired
//    private JobService js;
//    @Autowired
//    private UserService us;
    @Autowired
    RmiChoose rc;

    @RequestMapping(value = "/job", method = RequestMethod.GET)
    public ModelAndView showJob() {
        JobExample e1 = new JobExample();
        JobExample.Criteria c1 = e1.createCriteria();
        c1.andDirectionEqualTo("前端开发方向");
        List<Job> front =rc.getJobService().selectByExample(e1);

        JobExample e2 = new JobExample();
        JobExample.Criteria c2 = e2.createCriteria();
        c2.andDirectionEqualTo("后端开发方向");
        List<Job> behind =rc.getJobService().selectByExample(e2);

        JobExample e3 = new JobExample();
        JobExample.Criteria c3 = e3.createCriteria();
        c3.andDirectionEqualTo("运维方向");
        List<Job> maintain =rc.getJobService().selectByExample(e3);

        JobExample e4 = new JobExample();
        JobExample.Criteria c4 = e4.createCriteria();
        c4.andDirectionEqualTo("用户体验方向");
        List<Job> user =rc.getJobService().selectByExample(e4);


//        UserExample eu1 = new UserExample();
//        UserExample.Criteria cu1 = eu1.createCriteria();
//        cu1.andJobEqualTo("css");
//        long css = us.countByExample(eu1);
//
//        UserExample eu2 = new UserExample();
//        UserExample.Criteria cu2 = eu2.createCriteria();
//        cu2.andJobEqualTo("js");
//        long js = us.countByExample(eu2);
//
//        UserExample eu3 = new UserExample();
//        UserExample.Criteria cu3 = eu3.createCriteria();
//        cu3.andJobEqualTo("Android");
//        long android = us.countByExample(eu3);
//
//        UserExample eu4 = new UserExample();
//        UserExample.Criteria cu4 = eu4.createCriteria();
//        cu4.andJobEqualTo("ios");
//        long ios = us.countByExample(eu4);
//
//        UserExample eu5 = new UserExample();
//        UserExample.Criteria cu5 = eu5.createCriteria();
//        cu5.andJobEqualTo("java");
//        long java = us.countByExample(eu5);
//
//        UserExample eu6 = new UserExample();
//        UserExample.Criteria cu6 = eu6.createCriteria();
//        cu6.andJobEqualTo("python");
//        long python = us.countByExample(eu6);
//
//        UserExample eu7 = new UserExample();
//        UserExample.Criteria cu7 = eu7.createCriteria();
//        cu7.andJobEqualTo("op");
//        long op = us.countByExample(eu7);
//
//        UserExample eu8 = new UserExample();
//        UserExample.Criteria cu8 = eu8.createCriteria();
//        cu8.andJobEqualTo("pm");
//        long pm = us.countByExample(eu8);
//
//        UserExample eu9 = new UserExample();
//        UserExample.Criteria cu9 = eu9.createCriteria();
//        cu9.andJobEqualTo("ui");
//        long ui = us.countByExample(eu9);
//
//        UserExample eu10 = new UserExample();
//        UserExample.Criteria cu10 = eu10.createCriteria();
//        cu10.andJobEqualTo("qa");
//        long qa = us.countByExample(eu10);

        ModelAndView mav = new ModelAndView("job");
        mav.addObject("front", front);
        mav.addObject("behind", behind);
        mav.addObject("maintain", maintain);
        mav.addObject("user", user);

//        mav.addObject("css",css);
//        mav.addObject("js",js);
//        mav.addObject("android",android);
//        mav.addObject("ios",ios);
//        mav.addObject("java",java);
//        mav.addObject("python",python);
//        mav.addObject("op",op);
//        mav.addObject("pm",pm);
//        mav.addObject("ui",ui);
//        mav.addObject("qa",qa);
        return mav;
    }
}
