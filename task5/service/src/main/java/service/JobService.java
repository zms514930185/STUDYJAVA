package service;

import org.apache.ibatis.annotations.Param;
import pojo.Job;
import pojo.JobExample;

import java.util.List;

public interface JobService {
    int deleteByPrimaryKey(Long id);

    int insert(Job record);

    int insertSelective(Job record);

    List<Job> selectByExample(JobExample example);

    Job selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Job record, @Param("example") JobExample example);

    int updateByExample(@Param("record") Job record, @Param("example") JobExample example);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}