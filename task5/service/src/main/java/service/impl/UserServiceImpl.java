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
    private UserMapper um;
    public long countByExample(UserExample example) {
        return um.countByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(User record) {
        return 0;
    }

    public int insertSelective(User record) {
        return um.insertSelective(record);
    }

    public List<User> selectByExample(UserExample example) {
        return um.selectByExample(example);
    }

    public User selectByPrimaryKey(Long id) {
        return um.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    public int updateByPrimaryKey(User record) {
        return 0;
    }

    public User getByMobil(Long mobil) {
        return um.selectByMobil(mobil);
    }
}
