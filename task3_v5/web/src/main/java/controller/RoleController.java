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
import pojo.Page;
import pojo.Role;
import pojo.RoleExample;
import pojo.TableName;
import service.IsExist;
import service.RoleService;

import java.util.List;

@SuppressWarnings("Duplicates")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private IsExist isExist;

    @RequestMapping(value = "/a/u/role", method = RequestMethod.POST)
    public ModelAndView addRole(Role role){
        ModelAndView mav = new ModelAndView();
        String rolename=role.getRole();
        if (rolename==null||"".equals(rolename)){
            mav.addObject("code", -1);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("role","role",rolename);
        boolean exist=isExist.exist(tableName);
        if (exist){
            mav.addObject("code", -1);
            mav.addObject("message", "角色名重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        roleService.insert(role);
        mav.addObject("code", 0);
        mav.addObject("message", "success");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/role/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteById(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        if (0==id){
            mav.addObject("code", -1);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("role","role",id);
        boolean exist=isExist.exist(tableName);
        if (!exist) {
            mav.addObject("code", -1);
            mav.addObject("message", "角色不存在");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        roleService.deleteByPrimaryKey(id);
        mav.addObject("code", 0);
        mav.addObject("message", "success");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/role/", method = RequestMethod.PUT)
    public ModelAndView updateRole(Role role){
        ModelAndView mav = new ModelAndView();
        String rolename=role.getRole();
        if (rolename==null||"".equals(rolename)){
            mav.addObject("code", -100);
            mav.addObject("message", "error");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }
        TableName tableName = new TableName("role","role",rolename);
        boolean exist = isExist.exist(tableName);
        if (exist){
            mav.addObject("code", -1);
            mav.addObject("message", "账户名重复");
            mav.setView(new MappingJackson2JsonView());
            return mav;
        }

        roleService.updateByPrimaryKeySelective(role);
        mav.addObject("code", 0);
        mav.addObject("message", "修改成功");
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }

    @RequestMapping(value = "/a/u/role/{id}", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
//        只判断可以执行的可能，不可执行的全返error
        if(null!=id && 0!=id){
            Role role=roleService.selectByPrimaryKey(id);
            mav.addObject("role", role);
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

    @RequestMapping(value = "/a/u/role/list", method = RequestMethod.GET)
    public ModelAndView getList(Page page){
        ModelAndView mav = new ModelAndView();
        RoleExample example = new RoleExample();
        example.setOrderByClause("id desc");
        RoleExample.Criteria criteria = example.createCriteria();
        List<Role> array=roleService.selectByExample(example);
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
