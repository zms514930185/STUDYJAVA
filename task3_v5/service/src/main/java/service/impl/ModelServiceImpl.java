package service.impl;

import dao.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Model;
import pojo.ModelExample;
import service.ModelService;

import java.util.List;
@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelMapper modelMapper;
    public int deleteByPrimaryKey(Long id) {
        return modelMapper.deleteByPrimaryKey(id);
    }

    public int insert(Model record) {
        record.setCreateAt(System.currentTimeMillis());
        record.setUpdateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        record.setUpdateBy(1L);
        return modelMapper.insert(record);
    }

    public int insertSelective(Model record) {
        record.setCreateAt(System.currentTimeMillis());
        record.setUpdateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        record.setUpdateBy(1L);
        return modelMapper.insertSelective(record);
    }

    public List<Model> selectByExample(ModelExample example) {
        return modelMapper.selectByExample(example);
    }

    public Model selectByPrimaryKey(Long id) {
        return modelMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Model record) {
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(1L);
        return modelMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Model record) {
        return 0;
    }
}
