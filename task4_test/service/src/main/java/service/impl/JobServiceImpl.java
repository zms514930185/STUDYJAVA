package service.impl;

import dao.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Job;
import pojo.JobExample;
import service.JobService;

import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jm;
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Job record) {
        return 0;
    }

    public int insertSelective(Job record) {
        return 0;
    }

    public List<Job> selectByExample(JobExample example) {
        return jm.selectByExample(example);
    }

    public Job selectByPrimaryKey(Long id) {
        return jm.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(Job record, JobExample example) {
        return 0;
    }

    public int updateByExample(Job record, JobExample example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(Job record) {
        return 0;
    }

    public int updateByPrimaryKey(Job record) {
        return 0;
    }
}
