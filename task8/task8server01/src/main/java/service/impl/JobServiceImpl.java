package service.impl;

import dao.JobMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Job;
import pojo.JobExample;
import redis.RedisUtil;
import service.JobService;

import java.util.List;

//import memcached.Memcached;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jm;
//    @Autowired
//    private Memcached memcached;
    @Autowired
    private RedisUtil redisUtil;

    Logger logger = Logger.getLogger(JobServiceImpl.class);

//    public int deleteByPrimaryKey(Long id) {
//        return 0;
//    }

//    public int insert(Job record) {
//        return 0;
//    }

//    public int insertSelective(Job record) {
//        return 0;
//    }

    public List<Job> selectByExample(JobExample example) {
        //memcached方法
//        if (memcached.getObj("joblist") != null) {
//            logger.info("[logger]获取job列表缓存");
//            return (List<Job>) memcached.getObj("joblist");
//        }
//        logger.info("[logger]获取所有job列表数据");
//        List<Job> list=jm.selectByExample(example);
//        memcached.setMem("joblist",list);
//        return list;
        //redis方法
        if (redisUtil.get("joblist") != null) {
            logger.info("[logger]获取job列表缓存");
            return (List<Job>) redisUtil.get("joblist");
        }
        logger.info("[logger]获取所有job列表数据");
        List<Job> list=jm.selectByExample(example);
        redisUtil.set("joblist",list);
        return list;
    }

    public Job selectByPrimaryKey(Long id) {
        String jid="job"+id;
        //memcached
//        if (memcached.getObj(jid) != null) {
//            logger.info("[logger]获取jid列表缓存");
//            return (Job) memcached.getObj(jid);
//        }
//        logger.info("[logger]获取所有jid列表数据");
//        Job job=jm.selectByPrimaryKey(id);
//        memcached.setMem("joblist",job);
//        return job;
        //redis方法
        if (redisUtil.get(jid) != null) {
            logger.info("[logger]获取jid列表缓存");
            return (Job) redisUtil.get(jid);
        }
        logger.info("[logger]获取所有jid列表数据");
        Job job=jm.selectByPrimaryKey(id);
        redisUtil.set("joblist",job);
        return job;

    }

//    public int updateByExampleSelective(Job record, JobExample example) {
//        return 0;
//    }

//    public int updateByExample(Job record, JobExample example) {
//        return 0;
//    }

//    public int updateByPrimaryKeySelective(Job record) {
//        return 0;
//    }

//    public int updateByPrimaryKey(Job record) {
//        return 0;
//    }
}
