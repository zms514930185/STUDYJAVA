package service;

import org.apache.ibatis.annotations.Param;
import pojo.User;
import pojo.UserExample;

import java.util.List;


public interface UserService {
//    long countByExample(UserExample example);

//    int deleteByPrimaryKey(Long id);

//    int insert(User record);

    long insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

//    int updateByPrimaryKeySelective(User record);

//    int updateByPrimaryKey(User record);

    User getByMobil(@Param(value = "mobile") String mobile,@Param(value = "email") String email);
}