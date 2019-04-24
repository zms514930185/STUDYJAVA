package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import pojo.Model;
import pojo.ModelExample;
@Repository
public interface ModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Model record);

    int insertSelective(Model record);

    List<Model> selectByExample(ModelExample example);

    Model selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}