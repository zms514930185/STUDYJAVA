package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Category;
import service.CategoryService;
import util.Page;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService cs;

@RequestMapping(value = "/list-category",method = RequestMethod.GET)
    public ModelAndView listCategory(Page page){
    ModelAndView mav=new ModelAndView();
    PageHelper.offsetPage(page.getStart(),12);
    List<Category> list=cs.getlist();

//    int total = cs.total();
//    page.caculateLast(total);

    int total = (int) new PageInfo<>(list).getTotal();
    page.caculateLast(total);

    mav.addObject("list",list);
    mav.setViewName("list-category");
    return mav;
}

}
