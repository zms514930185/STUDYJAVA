package service.impl;

import dao.CompanyMapper;
import memcached.Memcached;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Company;
import pojo.CompanyExample;
import redis.RedisUtil;
import service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper cm;
    @Autowired
    private Memcached memcached;
    @Autowired
    private RedisUtil redisUtil;

    Logger logger = Logger.getLogger(CompanyServiceImpl.class);
//    public int deleteByPrimaryKey(Long id) {
//        return 0;
//    }

//    public int insert(Company record) {
//        return 0;
//    }

//    public int insertSelective(Company record) {
//        return 0;
//    }

    public List<Company> selectByExample(CompanyExample example) {
        //memcached方法
//        if (memcached.getObj("complist") != null) {
//            logger.info("[logger]获取缓存complist数据");
//            return (List<Company>) memcached.getObj("complist");
//        }
//        logger.info("[logger]获取数据库complist数据");
//        List<Company> list=cm.selectByExample(example);
//        memcached.setMem("complist",list);
//        logger.info("[logger]更新缓存complist数据");
//        return list;
        //redis方法
        if (redisUtil.get("complist") != null) {
            logger.info("[logger]获取缓存complist数据");
            return (List<Company>)redisUtil.get("complist");
        }
        logger.info("[logger]获取数据库complist数据");
        List<Company> list=cm.selectByExample(example);
        redisUtil.set("complist",list);
        logger.info("[logger]更新缓存complist数据");
        return list;
    }

    public Company selectByPrimaryKey(Long id) {
        String comp="company"+id;
        logger.info("[logger]"+comp);
//        if (memcached.getObj(comp) != null) {
//            logger.info("[logger]获取缓存comppany数据");
//            return (Company) memcached.getObj(comp);
//        }
//        logger.info("[logger]获取数据库comppanyt数据");
//        Company company=cm.selectByPrimaryKey(id);
//        memcached.setMem(comp,company);
//        logger.info("[logger]更新缓存comppany数据");
//        return company;
        if (redisUtil.get(comp) != null) {
            logger.info("[logger]获取缓存comppany数据");
            return (Company)redisUtil.get(comp);
        }
        logger.info("[logger]获取数据库comppanyt数据");
        Company company=cm.selectByPrimaryKey(id);
        redisUtil.set(comp,company);
        logger.info("[logger]更新缓存comppany数据");
        return company;
    }

//    public int updateByExampleSelective(Company record, CompanyExample example) {
//        return 0;
//    }

//    public int updateByExample(Company record, CompanyExample example) {
//        return 0;
//    }

//    public int updateByPrimaryKeySelective(Company record) {
//        return 0;
//    }

//    public int updateByPrimaryKey(Company record) {
//        return 0;
//    }
}
