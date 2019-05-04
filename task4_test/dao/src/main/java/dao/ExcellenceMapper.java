package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.Excellence;
import pojo.ExcellenceExample;
@Repository
public interface ExcellenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Excellence record);

    int insertSelective(Excellence record);

    List<Excellence> selectByExample(ExcellenceExample example);

    Excellence selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Excellence record, @Param("example") ExcellenceExample example);

    int updateByExample(@Param("record") Excellence record, @Param("example") ExcellenceExample example);

    int updateByPrimaryKeySelective(Excellence record);

    int updateByPrimaryKey(Excellence record);
}