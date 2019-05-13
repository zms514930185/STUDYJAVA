package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pojo.Company;
import pojo.CompanyExample;
import service.CompanyService;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    CompanyService cs;

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public ModelAndView getCompany(@RequestParam(defaultValue = "1") Long id){
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        List<Company> list=cs.selectByExample(example);
        Company company = cs.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("company");
        mav.addObject("company", company);
        mav.addObject("list", list);
        return mav;
    }



}
