package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Category;
import service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService cs;

@RequestMapping(value = "/list-category",method = RequestMethod.GET)
    public ModelAndView listCategory(){
    ModelAndView mav=new ModelAndView();
    List<Category> list=cs.getlist();

    mav.addObject("list",list);
    mav.setViewName("list-category");
    return mav;
}
}
