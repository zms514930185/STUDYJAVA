package service;

import org.apache.ibatis.annotations.Param;
import pojo.Excellence;
import pojo.ExcellenceExample;

import java.util.List;

public interface ExcellenceService {
//    int deleteByPrimaryKey(Long id);

//    int insert(Excellence record);

//    int insertSelective(Excellence record);

    List<Excellence> selectByExample(ExcellenceExample example);

//    Excellence selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") Excellence record, @Param("example") ExcellenceExample example);

//    int updateByExample(@Param("record") Excellence record, @Param("example") ExcellenceExample example);

//    int updateByPrimaryKeySelective(Excellence record);

//    int updateByPrimaryKey(Excellence record);
}