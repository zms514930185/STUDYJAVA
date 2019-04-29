package dao;

import pojo.Workshop;
import pojo.WorkshopExample;

import java.util.List;

public interface WorkshopMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Workshop record);

    int insertSelective(Workshop record);

    List<Workshop> selectByExample(WorkshopExample example);

    Workshop selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Workshop record);

    int updateByPrimaryKey(Workshop record);
}