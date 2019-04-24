package service.impl;

import org.springframework.stereotype.Service;
import pojo.Role;
import pojo.RoleExample;
import service.RoleService;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Role record) {
        return 0;
    }

    public int insertSelective(Role record) {
        return 0;
    }

    public List<Role> selectByExample(RoleExample example) {
        return null;
    }

    public Role selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

    public int updateByPrimaryKey(Role record) {
        return 0;
    }
}
