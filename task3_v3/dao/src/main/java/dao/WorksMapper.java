package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import pojo.Works;
import pojo.WorksExample;
@Repository
public interface WorksMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Works record);

    int insertSelective(Works record);

    List<Works> selectByExample(WorksExample example);

    Works selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKey(Works record);
}