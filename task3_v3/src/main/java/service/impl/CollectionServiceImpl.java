package service.impl;

import org.springframework.stereotype.Service;
import pojo.Collection;
import pojo.CollectionExample;
import service.CollectionService;

import java.util.List;
@Service
public class CollectionServiceImpl implements CollectionService {
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Collection record) {
        return 0;
    }

    public int insertSelective(Collection record) {
        return 0;
    }

    public List<Collection> selectByExample(CollectionExample example) {
        return null;
    }

    public Collection selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Collection record) {
        return 0;
    }

    public int updateByPrimaryKey(Collection record) {
        return 0;
    }
}
