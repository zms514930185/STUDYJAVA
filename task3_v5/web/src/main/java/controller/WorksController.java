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

import pojo.Works;
import pojo.WorksExample;
import service.IsExist;
import service.WorksService;


import java.util.List;

@Controller
public class WorksController {
    @Autowired
    IsExist isExist;
    @Autowired
    WorksService worksService;

    Logger logger=Logger.getLogger(WorksController.class);
    @RequestMapping(value = "/a/u/works", method = RequestMethod.POST)
    public ModelAndView addWorks(Works works, Page page){
        logger.info("[logger]"+works);
        ModelAndView mav = new ModelAndView();
        String name = works.getName();
        if (name==null||"".equals(name)){
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("works","name",name);
        boolean exist = isExist.exist(tableName);
        if (exist){
            mav.addObject("code", -1);
            mav.addObject("message", "作品名重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }


        worksService.insertSelective(works);
        mav.addObject("code", 0);
        mav.addObject("message", "添加成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/works/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteWorks(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        if (id==null||0==id) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("works", "id", id);
        boolean exist = isExist.exist(tableName);
        if (!exist) {
            mav.addObject("code", -1);
            mav.addObject("message", "作品不存在");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        worksService.deleteByPrimaryKey(id);
        mav.addObject("code", 0);
        mav.addObject("message", "删除成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/works", method = RequestMethod.PUT)
    public ModelAndView updateWorks(Works works){
        logger.info(works);
        ModelAndView mav = new ModelAndView();
        String name=works.getName();

        if (name==null||"".equals(name)){
            if (works.getStatus() != null) {
                worksService.updateByPrimaryKeySelective(works);
                mav.addObject("code", 0);
                mav.addObject("message", "修改成功");
                mav.setView(new MappingJackson2JsonView());
                return mav;
            }
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("works", "name", name);
        boolean exist = isExist.exist(tableName);
        if (exist){
            mav.addObject("code", -1);
            mav.addObject("message", "作品名重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        worksService.updateByPrimaryKeySelective(works);
        mav.addObject("code", 0);
        mav.addObject("message", "修改成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/works/{id}", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        //        只判断可以执行的可能，不可执行的全返error
        if(null!=id&&0!=id){
            Works works=worksService.selectByPrimaryKey(id);
            mav.addObject("works", works);
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

        //    id是作品集的id
    @RequestMapping(value = "/a/u/works/list/{id}", method = RequestMethod.GET)
    public ModelAndView getList(@PathVariable Long id,Page page){
        ModelAndView mav = new ModelAndView();
        WorksExample example = new WorksExample();
        example.setOrderByClause("id desc");
        WorksExample.Criteria criteria = example.createCriteria();
        criteria.andSecColEqualTo(id);
        List<Works> array=worksService.selectByExample(example);
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

    //    作品名模糊查找
    @RequestMapping(value = "/a/u/works/like/", method = RequestMethod.GET)
    public ModelAndView getWorksByName(String name,String status,Page page){
        ModelAndView mav = new ModelAndView();
        WorksExample example = new WorksExample();
        WorksExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%"+name+"%");
        criteria.andStatusEqualTo(status);
        List<Works> array=worksService.selectByExample(example);
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
