package service.impl;

import dao.UserMapper;
import memcached.Memcached;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import pojo.UserExample;
import redis.RedisUtil;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper um;
    @Autowired
    private Memcached memcached;
    @Autowired
    private RedisUtil redisUtil;

    Logger logger = Logger.getLogger(UserServiceImpl.class);

//    public long countByExample(UserExample example) {
//        return um.countByExample(example);
//    }

//    public int deleteByPrimaryKey(Long id) {
//        return 0;
//    }

//    public int insert(User record) {
//        return 0;
//    }

    @Override
    public long insertSelective(User record) {
        um.insertSelective(record);
        long id=record.getId();
        String key="user"+id;
        //memcached方法
        //memcached.setMem(key,record);
        //redis方法
        redisUtil.set(key, record);
        logger.info("[logger]更新新增用户缓存");
        return id;
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        //memcached方法
//        if (memcached.getObj("userlist") != null) {
//            logger.info("[logger]获取缓存中的userlist");
//            return (List<User>) memcached.getObj("userlist");
//        }
//        logger.info("[logger]获取数据库userlist信息");
//        List<User> list = um.selectByExample(example);
//        memcached.setMem("userlist",list);
//        logger.info("[更新userlist缓存]");
//        return list;
        //redis
        if (redisUtil.get("userlist") != null) {
            logger.info("[logger]获取缓存中的userlist");
            return (List<User>) redisUtil.get("userlist");
        }
        logger.info("[logger]获取数据库userlist信息");
        List<User> list = um.selectByExample(example);
        redisUtil.set("userlist",list);
        logger.info("[更新userlist缓存]");
        return list;
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        String key="user"+id;
        //memcached方法
//        if (memcached.getObj(key) != null) {
//            logger.info("[logger]获取缓存中的user对象");
//            return (User) memcached.getObj(key);
//        }
//        logger.info("[logger]获取数据库user信息");
//        User user = um.selectByPrimaryKey(id);
//        memcached.setMem(key,user);
//        logger.info("[logger]更新user缓存");
//        return user;
        //redis方法
        if (redisUtil.get(key) != null) {
            logger.info("[logger]获取缓存中的user对象");
            return (User) redisUtil.get(key);
        }
        logger.info("[logger]获取数据库user信息");
        User user = um.selectByPrimaryKey(id);
        redisUtil.set(key,user);
        logger.info("[logger]更新user缓存");
        return user;

    }

//    public int updateByPrimaryKeySelective(User record) {
//        return 0;
//    }

//    public int updateByPrimaryKey(User record) {
//        return 0;
//    }

    @Override
    public User getByMobil(@Param(value = "mobile") String mobile,@Param(value = "email") String email) {
        String key=null;
        if (null != mobile) {
            key="user"+mobile;
        }
        if (null != email) {
            key = "user" + email;
        }
        //memcached方法
//        if (memcached.getObj(key) != null) {
//            logger.info("[logger]获取缓存中的pwd对象");
//            return (User) memcached.getObj(key);
//        }
//        logger.info("[logger]获取数据库getByMobil信息");
//        User user = um.selectByMobil(mobil);
//        memcached.setMem(key,user);
//        logger.info("[更新userById缓存]");
//        return user;
        //redis方法
        if (redisUtil.get(key) != null) {
            logger.info("[logger]获取缓存中的pwd对象");
            return (User) redisUtil.get(key);
        }
        logger.info("[logger]获取数据库getByMobil信息");
        User user = um.selectByMobil(mobile,email);
        redisUtil.set(key,user);
        logger.info("[更新userById缓存]");
        return user;
    }
}
