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
import pojo.*;
import service.IsExist;
import service.ReplyService;

import java.util.List;

@Controller
public class ReplyController {
    @Autowired
    ReplyService replyService;
    @Autowired
    IsExist isExist;

    Logger logger = Logger.getLogger(ReplyController.class);

//    访客留言
    @RequestMapping(value = "/a/u/reply/visitor", method = RequestMethod.POST)
    public ModelAndView addReply(Reply reply){
        logger.info("[logger]"+reply);
        ModelAndView mav = new ModelAndView();

        if (reply.getReply()==null||"".equals(reply.getReply())){
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        reply.setReplyId("0");
        String replyId=reply.getReplyId();
        Long worksId =reply.getWorksId();
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria= example.createCriteria();
        criteria.andReplyIdEqualTo(replyId);
        criteria.andWorksIdEqualTo(worksId);
        List<Reply> list=replyService.selectByExample(example);
        if (list.size() > 0) {
            mav.addObject("code", -1);
            mav.addObject("message", "该作品已经留言");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        reply.setCreateBy(1L);
        replyService.insertSelective(reply);
        mav.addObject("code", 0);
        mav.addObject("message", "添加成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    //    管理员留言
    @RequestMapping(value = "/a/u/reply/manager", method = RequestMethod.POST)
    public ModelAndView addReplyManager(Reply reply){
        logger.info("[logger]"+reply);
        ModelAndView mav = new ModelAndView();

        if (reply.getReply()==null||"".equals(reply.getReply())){
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        String replyId= String.valueOf(reply.getId());
        reply.setReplyId(replyId);
        reply.setCreateBy(1L);
        replyService.insertSelective(reply);
        mav.addObject("code", 0);
        mav.addObject("message", "添加成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }



    @RequestMapping(value = "/a/u/reply/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteReply(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        if (id==null||0==id) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("reply", "id", id);
        boolean exist = isExist.exist(tableName);
        if (!exist) {
            mav.addObject("code", -1);
            mav.addObject("message", "留言不存在");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        replyService.deleteByPrimaryKey(id);
        mav.addObject("code", 0);
        mav.addObject("message", "删除成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/reply", method = RequestMethod.PUT)
    public ModelAndView updateReply(Reply reply){
        ModelAndView mav = new ModelAndView();
        String text = reply.getReply();
        Long id = reply.getId();
        if (text==null||"".equals(text)){
            if (reply.getStatus() != null) {
                replyService.updateByPrimaryKeySelective(reply);
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

        replyService.updateByPrimaryKeySelective(reply);
        mav.addObject("code", 0);
        mav.addObject("message", "修改成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/reply/{id}", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        //        只判断可以执行的可能，不可执行的全返error
        if(null!=id&&0!=id){
            Reply reply=replyService.selectByPrimaryKey(id);
            mav.addObject("reply", reply);
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

    @RequestMapping(value = "/a/u/reply/list", method = RequestMethod.GET)
    public ModelAndView getList(Page page){
        ModelAndView mav = new ModelAndView();
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
        criteria.andReplyIdEqualTo("0");
        List<Reply> array=replyService.selectByExample(example);
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

    //    ID查找
    @RequestMapping(value = "/a/u/reply/like/{workId}&{status}", method = RequestMethod.GET)
    public ModelAndView getReplyByWorkId(@PathVariable Long workId,@PathVariable String status,Page page){
        ModelAndView mav = new ModelAndView();
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
        criteria.andWorksIdEqualTo(workId);
        criteria.andStatusEqualTo(status);
        List<Reply> array=replyService.selectByExample(example);
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
