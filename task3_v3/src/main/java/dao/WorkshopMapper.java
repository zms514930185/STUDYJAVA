package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import pojo.Workshop;
import pojo.WorkshopExample;
@Repository
public interface WorkshopMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Workshop record);

    int insertSelective(Workshop record);

    List<Workshop> selectByExample(WorkshopExample example);

    Workshop selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Workshop record);

    int updateByPrimaryKey(Workshop record);
}