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
import pojo.Collection;
import pojo.CollectionExample;
import pojo.Page;
import pojo.TableName;

import service.CollectionService;
import service.IsExist;

import java.util.List;
@SuppressWarnings("Duplicates")
@Controller
public class CollectionController {
    @Autowired
    CollectionService cs;
    @Autowired
    IsExist isExist;

    Logger logger = Logger.getLogger(CollectionController.class);

    @RequestMapping(value = "/a/u/collection", method = RequestMethod.POST)
    public ModelAndView addCollection(Collection collection) {
        logger.info("[logger]" + collection);
        ModelAndView mav = new ModelAndView();
        String name = collection.getName();
        if (name==null||"".equals(name)) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("collection", "name", name);
        boolean exist = isExist.exist(tableName);
        if (exist) {
            mav.addObject("code", -1);
            mav.addObject("message", "命名重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        CollectionExample example = new CollectionExample();
        CollectionExample.Criteria criteria = example.createCriteria();
        criteria.andLidEqualTo(0L);
        List<Collection> array = cs.selectByExample(example);
        if (array.size() > 6) {
            mav.addObject("code", -1);
            mav.addObject("message", "作品集超过数量");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        collection.setSeq(array.size() + 1);
        collection.setLid(0L);
        cs.insertSelective(collection);
        mav.addObject("code", 0);
        mav.addObject("message", "添加成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/collection/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteCollertion(@PathVariable Long id) {
        logger.info("[logger\tid:]" + id);
        ModelAndView mav = new ModelAndView();
        if (id == null || 0 == id) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("collection", "id", id);
        boolean exist = isExist.exist(tableName);
        if (!exist) {
            mav.addObject("code", -1);
            mav.addObject("message", "作品集不存在");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        cs.deleteByPrimaryKey(id);
        mav.addObject("code", 0);
        mav.addObject("message", "删除成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/collection", method = RequestMethod.PUT)
    public ModelAndView updateCollertion(Collection collection) {
        logger.info("[logger]\tcollection:" + collection);
        ModelAndView mav = new ModelAndView();
        String name = collection.getName();
        if (name==null||"".equals(name)) {
            if (collection.getStatus() != null) {
                cs.updateByPrimaryKeySelective(collection);
                mav.addObject("code", 0);
                mav.addObject("message", "修改成功");
                mav.setView(new MappingJackson2JsonView());
            }
            mav.addObject("code", -100);
            mav.addObject("message", "内容不能为空");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("collection", "name", name);
        boolean exist = isExist.exist(tableName);
        if (exist) {
            mav.addObject("code", -1);
            mav.addObject("message", "作品集重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        cs.updateByPrimaryKeySelective(collection);
        mav.addObject("code", 0);
        mav.addObject("message", "修改成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/collection/{id}", method = RequestMethod.GET)
    public ModelAndView getCollertionById(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        //        只判断可以执行的可能，不可执行的全返error
        if (null != id && 0 != id) {

            Collection collection = cs.selectByPrimaryKey(id);
            mav.addObject("collection", collection);
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

    @RequestMapping(value = "/a/u/collection/list", method = RequestMethod.GET)
    public ModelAndView getCollertionList(Page page) {
        ModelAndView mav = new ModelAndView();
        CollectionExample example = new CollectionExample();
        example.setOrderByClause("seq desc");
        CollectionExample.Criteria criteria = example.createCriteria();
        criteria.andLidEqualTo(0L);
        List<Collection> array = cs.selectByExample(example);
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

    //    名称模糊查找 全部状态下 status返回null
    @RequestMapping(value = "/a/u/collection/like", method = RequestMethod.GET)
    public ModelAndView getCollertionByName(String name,Integer status, Page page) {
        logger.info("[logger]"+name);
        logger.info("[logger]"+status);
        ModelAndView mav = new ModelAndView();
        CollectionExample example = new CollectionExample();
        CollectionExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%" + name + "%");
        criteria.andStatusEqualTo(status);
        List<Collection> array = cs.selectByExample(example);
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

    /**
     * 作品集二级目录
     */

    @RequestMapping(value = "/a/u/collection/child", method = RequestMethod.POST)
    public ModelAndView addCollertionChild(Long id,String name) {
        logger.info("[logger]"+id);
        logger.info("[logger]"+name);
        Collection collection = new Collection();
//        logger.info("[logger]" + collection);
        ModelAndView mav = new ModelAndView();

        if (name==null||"".equals(name)) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("collection", "name", name);
        boolean exist = isExist.exist(tableName);
        if (exist) {
            mav.addObject("code", -1);
            mav.addObject("message", "命名重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        CollectionExample example = new CollectionExample();
        CollectionExample.Criteria criteria = example.createCriteria();
        criteria.andLidEqualTo(id);
        List<Collection> array = cs.selectByExample(example);
        if (array.size() > 6) {
            mav.addObject("code", -1);
            mav.addObject("message", "作品集超过数量");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        collection.setSeq(array.size() + 1);
        collection.setLid(id);
        collection.setName(name);
        logger.info("[logger]\tlid:" + collection.getLid());
        collection.setId(null);
        logger.info("[logger]\tid:" + collection.getId());
        cs.insertSelective(collection);
        mav.addObject("code", 0);
        mav.addObject("message", "添加成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/collectionChild/{id}", method = RequestMethod.GET)
    public ModelAndView getCollertionChildByLid(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        //        只判断可以执行的可能，不可执行的全返error
        if (null != id && 0 != id) {
            CollectionExample example = new CollectionExample();
            CollectionExample.Criteria criteria = example.createCriteria();
            criteria.andLidEqualTo(id);
            List<Collection> array = cs.selectByExample(example);
            mav.addObject("array", array);
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

//    按照排序倒序写入数组
    @RequestMapping(value = "/a/u/collection/seq", method = RequestMethod.PUT)
    public ModelAndView updateSeq(Long[] ids) {
        ModelAndView mav = new ModelAndView();

        for (Long id : ids) {
            Collection collection = new Collection();
            int index = 1;
            collection.setSeq(index);
            collection.setId(id);
            cs.updateByPrimaryKeySelective(collection);
            index++;
        }
        return mav;
    }
}



