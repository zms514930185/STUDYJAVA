package service.impl;

import dao.WorksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Works;
import pojo.WorksExample;
import service.WorksService;

import java.util.List;
@Service
public class WorksServiceImpl implements WorksService {
    @Autowired
    private WorksMapper worksMapper;
    public int deleteByPrimaryKey(Long id) {
        return worksMapper.deleteByPrimaryKey(id);
    }

    public int insert(Works record) {
        record.setCreateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(2L);
        return worksMapper.insert(record);
    }

    public int insertSelective(Works record) {
        return worksMapper.insert(record);
    }

    public List<Works> selectByExample(WorksExample example) {
        return worksMapper.selectByExample(example);
    }

    public Works selectByPrimaryKey(Long id) {
        return worksMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Works record) {
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(1L);
        return worksMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Works record) {
        return worksMapper.updateByPrimaryKey(record);
    }
}
