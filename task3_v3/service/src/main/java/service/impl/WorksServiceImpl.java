package service.impl;

import org.springframework.stereotype.Service;
import pojo.Works;
import pojo.WorksExample;
import service.WorksService;

import java.util.List;
@Service
public class WorksServiceImpl implements WorksService {
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Works record) {
        return 0;
    }

    public int insertSelective(Works record) {
        return 0;
    }

    public List<Works> selectByExample(WorksExample example) {
        return null;
    }

    public Works selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Works record) {
        return 0;
    }

    public int updateByPrimaryKey(Works record) {
        return 0;
    }
}
