package service.impl;

import org.springframework.stereotype.Service;
import pojo.User;
import pojo.UserExample;
import service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(User record) {
        return 0;
    }

    public int insertSelective(User record) {
        return 0;
    }

    public List<User> selectByExample(UserExample example) {
        return null;
    }

    public User selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
