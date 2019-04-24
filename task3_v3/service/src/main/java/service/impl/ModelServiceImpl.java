package service.impl;

import org.springframework.stereotype.Service;
import pojo.Model;
import pojo.ModelExample;
import service.ModelService;

import java.util.List;
@Service
public class ModelServiceImpl implements ModelService {
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Model record) {
        return 0;
    }

    public int insertSelective(Model record) {
        return 0;
    }

    public List<Model> selectByExample(ModelExample example) {
        return null;
    }

    public Model selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Model record) {
        return 0;
    }

    public int updateByPrimaryKey(Model record) {
        return 0;
    }
}
