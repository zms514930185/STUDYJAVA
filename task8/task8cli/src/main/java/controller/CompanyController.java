package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pojo.Company;
import pojo.CompanyExample;
import service.CompanyService;
import service.RmiChoose;

import java.util.List;

@Controller
public class CompanyController {
//    @Autowired
//    CompanyService cs;
    @Autowired
    RmiChoose rc;

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public ModelAndView getCompany(@RequestParam(defaultValue = "1") Long id){
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        List<Company> list=rc.getCompanyService().selectByExample(example);
        Company company = rc.getCompanyService().selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("company");
        mav.addObject("company", company);
        mav.addObject("list", list);

        return mav;
    }



}
