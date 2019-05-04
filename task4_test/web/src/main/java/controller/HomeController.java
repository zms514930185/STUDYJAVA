package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Excellence;
import pojo.ExcellenceExample;
import service.ExcellenceService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ExcellenceService es;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView excellenceView(){
        ExcellenceExample example = new ExcellenceExample();
        example.setOrderByClause("pay desc");
        ExcellenceExample.Criteria criteria = example.createCriteria();
        List<Excellence> list = es.selectByExample(example);
        List<Excellence> array = new ArrayList<>();
        if (list.size() > 5) {
             array = list.subList(0, 4);
        } else {
            array=list;
        }
        ModelAndView mav = new ModelAndView("excellence");
        mav.addObject("list",array);
        return mav;
    }

//    @RequestMapping("/")
//    public String testView(){
//        return "excellence";
//    }
}
