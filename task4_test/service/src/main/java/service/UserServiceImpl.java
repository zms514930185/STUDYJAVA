package service;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import pojo.UserExample;

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
        return 0;
    }

    public List<User> selectByExample(UserExample example) {
        return null;
    }

    public User selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByExampleSelective(User record, UserExample example) {
        return 0;
    }

    public int updateByExample(User record, UserExample example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
