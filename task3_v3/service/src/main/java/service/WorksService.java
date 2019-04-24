package service;

import pojo.Works;
import pojo.WorksExample;

import java.util.List;

public interface WorksService {
    int deleteByPrimaryKey(Long id);

    int insert(Works record);

    int insertSelective(Works record);

    List<Works> selectByExample(WorksExample example);

    Works selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKey(Works record);
}