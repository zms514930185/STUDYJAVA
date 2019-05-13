package service;

import org.springframework.stereotype.Repository;
import pojo.User;
import pojo.UserExample;

import java.util.List;


public interface UserService {
    long countByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getByMobil(Long mobil);
}