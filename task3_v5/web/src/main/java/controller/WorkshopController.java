package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import pojo.Page;
import pojo.TableName;
import pojo.Workshop;
import pojo.WorkshopExample;
import service.IsExist;
import service.WorkshopService;

import java.util.List;

@Controller
public class WorkshopController {

    Logger logger = Logger.getLogger(WorkshopController.class);
    @Autowired
    IsExist isExist;
    @Autowired
    WorkshopService workshopService;

    @RequestMapping(value = "/a/u/workshop", method = RequestMethod.POST)
    public ModelAndView addWorkshop(Workshop workshop){
        logger.info("[logger]"+workshop);
        ModelAndView mav = new ModelAndView();
        String name = workshop.getName();
        String image = workshop.getImage();
        String introduction = workshop.getIntroduction();
        if (name==null||"".equals(name)|| image==null||"".equals(image)||
                introduction==null||"".equals(introduction)) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        workshopService.insertSelective(workshop);
        mav.addObject("code", 0);
        mav.addObject("message", "添加成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/workshop/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteWorkshop(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        if (id==null||0==id) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        workshopService.deleteByPrimaryKey(id);
        mav.addObject("code", 0);
        mav.addObject("message", "删除成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/workshop", method = RequestMethod.PUT)
    public ModelAndView updateWorkshop(Workshop workshop){
        logger.info("[logger]"+workshop);
        ModelAndView mav = new ModelAndView();
        String name = workshop.getName();
        String image = workshop.getImage();
        String introduction = workshop.getIntroduction();
        if (name==null||"".equals(name)|| image==null||"".equals(image)||
                introduction==null||"".equals(introduction)) {
            if (workshop.getStatus() != null) {
                workshopService.updateByPrimaryKeySelective(workshop);
                mav.addObject("code", 0);
                mav.addObject("message", "修改成功");
                mav.setView(new MappingJackson2JsonView());
            }
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("workshop","name",name);
        boolean exist = isExist.exist(tableName);
        if (!exist){
            mav.addObject("code", -1);
            mav.addObject("message", "不存在");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        workshopService.updateByPrimaryKeySelective(workshop);
        mav.addObject("code", 0);
        mav.addObject("message", "修改成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/workshop/{id}", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        //        只判断可以执行的可能，不可执行的全返error
        if (null != id && 0 != id) {
            Workshop workshop=workshopService.selectByPrimaryKey(id);
            mav.addObject("workshop", workshop);
            mav.addObject("code", 0);
            mav.addObject("message", "success");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        mav.addObject("code", -100);
        mav.addObject("message", "error");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/workshop/list", method = RequestMethod.GET)
    public ModelAndView getList(Page page){
        ModelAndView mav = new ModelAndView();
        WorkshopExample example = new WorkshopExample();
        example.setOrderByClause("id desc");
        WorkshopExample.Criteria criteria = example.createCriteria();
        List<Workshop> array=workshopService.selectByExample(example);
        //        分页显示
        PageHelper.offsetPage(page.getStart(), page.getCount());
        int total = (int) new PageInfo<>(array).getTotal();
        page.setTotal(total);
        mav.addObject("array", array);
        mav.addObject("code", 0);
        mav.addObject("message", "success");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    //    姓名模糊查找
    @RequestMapping(value = "/a/u/workshop/like/", method = RequestMethod.GET)
    public ModelAndView getWorkshopByName(String name,Page page){
        ModelAndView mav = new ModelAndView();
        WorkshopExample example = new WorkshopExample();
        WorkshopExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%"+name+"%");
        List<Workshop> array=workshopService.selectByExample(example);
        //        分页显示
        PageHelper.offsetPage(page.getStart(), page.getCount());
        int total = (int) new PageInfo<>(array).getTotal();
        page.setTotal(total);
        mav.addObject("array", array);
        mav.addObject("code", 0);
        mav.addObject("message", "success");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }
}
