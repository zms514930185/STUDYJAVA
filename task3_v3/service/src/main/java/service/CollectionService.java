package service;

import pojo.Collection;
import pojo.CollectionExample;

import java.util.List;

public interface CollectionService {
    int deleteByPrimaryKey(Long id);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    Collection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}