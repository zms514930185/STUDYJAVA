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
import pojo.Banner;
import pojo.BannerExample;
import pojo.Page;
import pojo.TableName;
import service.BannerService;
import service.IsExist;

import java.util.List;
@SuppressWarnings("Duplicates")
@Controller
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private IsExist isExist;

    Logger logger = Logger.getLogger(BannerController.class);

    @RequestMapping(value = "/a/u/banner", method = RequestMethod.POST)
    public ModelAndView addBanner(Banner banner){
        try {
            logger.info("[logger]" + banner);
            ModelAndView mav = new ModelAndView();
            String url = banner.getUrl();
            String image = banner.getImage();
            if (url == null || image == null) {
                mav.addObject("code", -100);
                mav.addObject("message", "内容不能为空");
                mav.setView(new MappingJackson2JsonView());
                return mav;
            }
            BannerExample example = new BannerExample();
            BannerExample.Criteria criteria = example.createCriteria();
            List<Banner> array = bannerService.selectByExample(example);
            banner.setSeq(array.size());
            bannerService.insertSelective(banner);
            mav.addObject("code", 0);
            mav.addObject("message", "添加成功");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("code", -1000);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
    }

    @RequestMapping(value = "/a/u/banner/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteBanner(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        if (id==null||0==id) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("banner", "id", id);
        boolean exist = isExist.exist(tableName);
        if (!exist) {
            mav.addObject("code", -1);
            mav.addObject("message", "banner不存在");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        bannerService.deleteByPrimaryKey(id);
        mav.addObject("code", 0);
        mav.addObject("message", "删除成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/banner", method = RequestMethod.PUT)
    public ModelAndView updateBanner(Banner banner){
        ModelAndView mav = new ModelAndView();
        String url = banner.getUrl();
        String image = banner.getImage();
        logger.info("[logger]"+url);
        logger.info("[logger]"+image);
        if (url==null || image==null||"".equals(url)|| "".equals(image)) {
            if (banner.getStatus() != null) {
                bannerService.updateByPrimaryKeySelective(banner);
                mav.addObject("code", 0);
                mav.addObject("message", "修改成功");
                mav.setView(new MappingJackson2JsonView());
            }
            mav.addObject("code", -100);
            mav.addObject("message", "内容不能为空");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        bannerService.updateByPrimaryKeySelective(banner);
        mav.addObject("code", 0);
        mav.addObject("message", "修改成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/banner/{id}", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        //        只判断可以执行的可能，不可执行的全返error
        if(null!=id&&0!=id){
            Banner banner=bannerService.selectByPrimaryKey(id);
            mav.addObject("banner", banner);
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

    @RequestMapping(value = "/a/u/banner/list", method = RequestMethod.GET)
    public ModelAndView getList(Page page){
        ModelAndView mav = new ModelAndView();
        BannerExample example = new BannerExample();
        example.setOrderByClause("seq desc");
        BannerExample.Criteria criteria = example.createCriteria();
        List<Banner> array=bannerService.selectByExample(example);
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
    @RequestMapping(value = "/a/u/banner/like", method = RequestMethod.GET)
    public ModelAndView getBannerByEditor(String editor,String status,Page page){
        logger.info("[logger]"+editor);
        logger.info("[logger]"+status);
        ModelAndView mav = new ModelAndView();
        BannerExample example = new BannerExample();
        BannerExample.Criteria criteria = example.createCriteria();
        criteria.andEditorLike("%"+editor+"%");
        criteria.andStatusEqualTo(status);
        List<Banner> array=bannerService.selectByExample(example);
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

    //    按照排序倒序写入数组
    @RequestMapping(value = "/a/u/banner/seq", method = RequestMethod.PUT)
    public ModelAndView updateSeq(Long[] ids) {
        ModelAndView mav = new ModelAndView();
        int index = 1;
        for (Long id : ids) {
            Banner banner = new Banner();


            banner.setSeq(index);
            banner.setId(id);
            bannerService.updateByPrimaryKeySelective(banner);
            index++;
        }
        return mav;
    }
}
