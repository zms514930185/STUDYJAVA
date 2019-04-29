package service.impl;

import dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Role;
import pojo.RoleExample;
import service.RoleService;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    public int insert(Role record) {
        record.setCreateAt(System.currentTimeMillis());
        record.setUpdateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        record.setUpdateBt(2L);
        return roleMapper.insert(record);
    }

    public int insertSelective(Role record) {

        return roleMapper.insertSelective(record);
    }

    public List<Role> selectByExample(RoleExample example) {
        return roleMapper.selectByExample(example);
    }

    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Role record) {
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBt(1L);
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }
}
