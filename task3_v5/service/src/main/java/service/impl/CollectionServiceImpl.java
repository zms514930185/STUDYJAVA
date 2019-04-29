package service.impl;

import dao.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Collection;
import pojo.CollectionExample;
import service.CollectionService;

import java.util.List;
@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    public int deleteByPrimaryKey(Long id) {
        return collectionMapper.deleteByPrimaryKey(id);
    }

    public int insert(Collection record) {
        record.setStatus(0);
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(1L);
        record.setCreateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        return collectionMapper.insert(record);
    }

    public int insertSelective(Collection record) {
        record.setStatus(0);
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(1L);
        record.setCreateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        return collectionMapper.insertSelective(record);
    }

    public List<Collection> selectByExample(CollectionExample example) {
        return collectionMapper.selectByExample(example);
    }

    public Collection selectByPrimaryKey(Long id) {
        return collectionMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Collection record) {
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(1L);
        return collectionMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Collection record) {
        return collectionMapper.updateByPrimaryKey(record);
    }
}
