package service.impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import pojo.UserExample;
import service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record) {
        record.setCreateAt(System.currentTimeMillis());
        record.setUpdateAt(System.currentTimeMillis());
//        //        后期修改
//        record.setCreateBy(1L);
//        //        后期修改
//        record.setUpdateBy(1L);
        return userMapper.insert(record);
    }

    public int insertSelective(User record) {
        record.setCreateAt(System.currentTimeMillis());
        record.setUpdateAt(System.currentTimeMillis());
//        //        后期修改
//        record.setCreateBy(System.currentTimeMillis());
//        //        后期修改
//        record.setUpdateBy(System.currentTimeMillis());
        return userMapper.insertSelective(record);
    }

    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record) {
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(0L);
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        record.setUpdateAt(System.currentTimeMillis());
        return userMapper.updateByPrimaryKey(record);
    }
}
