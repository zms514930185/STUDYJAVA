package service.impl;

import dao.ExcellenceMapper;
import memcached.Memcached;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Excellence;
import pojo.ExcellenceExample;
import redis.RedisUtil;
import service.ExcellenceService;

import java.util.List;

@Service
public class ExcellenceServiceImpl implements ExcellenceService {

    @Autowired
    private ExcellenceMapper em;
    @Autowired
    private Memcached memcached;
    @Autowired
    private RedisUtil redisUtil;

    Logger logger=Logger.getLogger(ExcellenceServiceImpl.class);
//    public int deleteByPrimaryKey(Long id) {
//        return 0;
//    }

//    public int insert(Excellence record) {
//        return 0;
//    }

//    public int insertSelective(Excellence record) {
//        return 0;
//    }

    public List<Excellence> selectByExample(ExcellenceExample example) {
        //memcached方法
//        if (memcached.getObj("homelist")!= null) {
//            logger.info("[logger]获取缓存中home页数据");
//            return (List<Excellence>) memcached.getObj("homelist");
//        }
//        logger.info("[logger]获取数据库homelist数据");
//        List<Excellence> list=em.selectByExample(example);
//        memcached.setMem("homelist",list);
//        return list;
        //redis方法
        if (redisUtil.get("homelist")!= null) {
            logger.info("[logger]获取缓存中home页数据");
            return (List<Excellence>) redisUtil.get("homelist");
        }
        logger.info("[logger]获取数据库homelist数据");
        List<Excellence> list=em.selectByExample(example);
        redisUtil.set("homelist",list);
        return list;
    }

//    public Excellence selectByPrimaryKey(Long id) {
//        return null;
//    }

//    public int updateByExampleSelective(Excellence record, ExcellenceExample example) {
//        return 0;
//    }

//    public int updateByExample(Excellence record, ExcellenceExample example) {
//        return 0;
//    }

//    public int updateByPrimaryKeySelective(Excellence record) {
//        return 0;
//    }

//    public int updateByPrimaryKey(Excellence record) {
//        return 0;
//    }
}
