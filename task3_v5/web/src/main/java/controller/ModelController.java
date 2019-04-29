package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import pojo.Model;
import pojo.ModelExample;
import pojo.Page;
import pojo.TableName;
import service.IsExist;
import service.ModelService;

import java.util.List;

@Controller
public class ModelController {
    @Autowired
    ModelService modelService;
    @Autowired
    IsExist isExist;

    @RequestMapping(value = "/a/u/model", method = RequestMethod.POST)
    public ModelAndView addModel(Model model){
        ModelAndView mav = new ModelAndView();

        if ("".equals(model.getModName())|| null == model.getModName()) {
            mav.addObject("code", -1);
            mav.addObject("message", "模块名不能为空");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        if ("".equals(model.getParentnode()) || null == model.getParentnode()) {
            mav.addObject("code", -1);
            mav.addObject("message", "父节点不能为空");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        TableName modName = new TableName("model","mod_name",model.getModName());
        boolean modExist = isExist.exist(modName);
        if (modExist){
            mav.addObject("code", -1);
            mav.addObject("message", "模块存在");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        modelService.insertSelective(model);
        mav.addObject("code", 0);
        mav.addObject("message", "添加成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/model/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteModel(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        if (null == id || 0 == id) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("model", "id", id);
        boolean exist = isExist.exist(tableName);
        if (!exist) {
            mav.addObject("code", -1);
            mav.addObject("message", "模块不存在");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        modelService.deleteByPrimaryKey(id);
        mav.addObject("code", 0);
        mav.addObject("message", "删除成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/model", method = RequestMethod.PUT)
    public ModelAndView updateModel(Model model){
        ModelAndView mav = new ModelAndView();
        String modName = model.getModName();
        Integer parentnode = model.getParentnode();
        if (modName==null||"".equals(modName)||null==parentnode||0==parentnode){
            mav.addObject("code", -1);
            mav.addObject("message", "模块名不能为空");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("model","mod_name",modName);
        boolean exist = isExist.exist(tableName);
        if (exist){
            mav.addObject("code", -1);
            mav.addObject("message", "模块名重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        modelService.updateByPrimaryKeySelective(model);
        mav.addObject("code", 0);
        mav.addObject("message", "修改成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/model/{id}", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
//        只判断可以执行的可能，不可执行的全返error
        if (null != id && 0 != id) {
            Model model=modelService.selectByPrimaryKey(id);
            mav.addObject("model", model);
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

    @RequestMapping(value = "/a/u/model/list", method = RequestMethod.GET)
    public ModelAndView getList(Page page){
        ModelAndView mav = new ModelAndView();
        ModelExample example = new ModelExample();
        example.setOrderByClause("id desc");
        ModelExample.Criteria criteria = example.createCriteria();
        List<Model> array=modelService.selectByExample(example);
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
    @RequestMapping(value = "/a/u/model/like", method = RequestMethod.GET)
    public ModelAndView getModelByModname(String modName, Page page){
        ModelAndView mav = new ModelAndView();
        ModelExample example = new ModelExample();
        ModelExample.Criteria criteria = example.createCriteria();
        criteria.andModNameLike("%"+modName+"%");
        List<Model> array=modelService.selectByExample(example);
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
