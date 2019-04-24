package service.impl;

import org.springframework.stereotype.Service;
import pojo.Workshop;
import pojo.WorkshopExample;
import service.WorkshopService;

import java.util.List;
@Service
public class WorkshopServiceImpl implements WorkshopService {
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Workshop record) {
        return 0;
    }

    public int insertSelective(Workshop record) {
        return 0;
    }

    public List<Workshop> selectByExample(WorkshopExample example) {
        return null;
    }

    public Workshop selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Workshop record) {
        return 0;
    }

    public int updateByPrimaryKey(Workshop record) {
        return 0;
    }
}
