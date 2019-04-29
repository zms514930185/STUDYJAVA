package service.impl;

import dao.WorkshopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Workshop;
import pojo.WorkshopExample;
import service.WorkshopService;

import java.util.List;
@Service
public class WorkshopServiceImpl implements WorkshopService {
    @Autowired
    private WorkshopMapper workshopMapper;
    public int deleteByPrimaryKey(Long id) {
        return workshopMapper.deleteByPrimaryKey(id);
    }

    public int insert(Workshop record) {
        record.setCreateAt(System.currentTimeMillis());
        record.setUpdateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        record.setUpdateBy(2L);
        return workshopMapper.insert(record);
    }

    public int insertSelective(Workshop record) {
        record.setCreateAt(System.currentTimeMillis());
        record.setUpdateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        record.setUpdateBy(2L);
        return workshopMapper.insertSelective(record);
    }

    public List<Workshop> selectByExample(WorkshopExample example) {
        return workshopMapper.selectByExample(example);
    }

    public Workshop selectByPrimaryKey(Long id) {
        return workshopMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Workshop record) {
        record.setUpdateBy(1L);
        record.setUpdateAt(System.currentTimeMillis());
        return workshopMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Workshop record) {

        return workshopMapper.updateByPrimaryKey(record);
    }
}
