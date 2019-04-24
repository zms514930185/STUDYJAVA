package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import pojo.Collection;
import pojo.CollectionExample;
@Repository
public interface CollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    Collection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}