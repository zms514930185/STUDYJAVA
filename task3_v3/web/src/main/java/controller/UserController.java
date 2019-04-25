package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import pojo.TableName;

import pojo.User;
import pojo.UserExample;
import service.IsExist;
import service.UserService;

import java.util.List;

@SuppressWarnings("Duplicates")
@Controller
public class UserController {

    Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    IsExist isExist;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/a/u/user", method = RequestMethod.POST)
    public ModelAndView addUser(User user){
        logger.info("[logger]"+user);
        ModelAndView mav = new ModelAndView();
        String username = user.getUsername();
        String password = user.getPassword();
        Long roleId = user.getRoleId();
        if (username==null||"".equals(username)||password==null||"".equals(password)||roleId==null||"".equals(roleId)){
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("user","username",username);
        boolean exist = isExist.exist(tableName);
        if (exist){
            mav.addObject("code", -1);
            mav.addObject("message", "账户名重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        user.setUpdateBy(1L);
        user.setCreateBy(1L);
        userService.insert(user);
        mav.addObject("code", 0);
        mav.addObject("message", "添加成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/user/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteUser(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        if (id==null||"".equals(id)) {
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("user", "id", id);
        boolean exist = isExist.exist(tableName);
        if (exist == false) {
            mav.addObject("code", -1);
            mav.addObject("message", "账户名不存在");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        userService.deleteByPrimaryKey(id);
        mav.addObject("code", 0);
        mav.addObject("message", "删除成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/user", method = RequestMethod.PUT)
    public ModelAndView updateUser(User user){
        ModelAndView mav = new ModelAndView();
        String username=user.getUsername();
        String password = user.getPassword();
        Long roleId = user.getRoleId();
        if (username==null||"".equals(username)||password==null||"".equals(password)||roleId==null||"".equals(roleId)){
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("user","username",username);
        boolean exist = isExist.exist(tableName);
        if (exist==true){
            mav.addObject("code", -1);
            mav.addObject("message", "账户名重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        userService.updateByPrimaryKeySelective(user);
        mav.addObject("code", 0);
        mav.addObject("message", "添加成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/user/{id}", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
//        只判断可以执行的可能，不可执行的全返error
        if(null!=id&&!"".equals(id)){
            userService.deleteByPrimaryKey(id);
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

    @RequestMapping(value = "/a/u/user/list", method = RequestMethod.GET)
    public ModelAndView getList(){
        ModelAndView mav = new ModelAndView();
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        UserExample.Criteria criteria = example.createCriteria();
        List<User> array=userService.selectByExample(example);
        mav.addObject("array", array);
        mav.addObject("code", 0);
        mav.addObject("message", "success");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/user/{username}", method = RequestMethod.GET)
    public ModelAndView getUserByUsername(String username,Long roleId){
        ModelAndView mav = new ModelAndView();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameLike(username);
        criteria.andRoleIdEqualTo(roleId);
        userService.selectByExample(example);
        mav.addObject("code", 0);
        mav.addObject("message", "success");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }
}

