package service.impl;

import dao.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Banner;
import pojo.BannerExample;
import service.BannerService;

import java.util.List;
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    public int deleteByPrimaryKey(Long id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    public int insert(Banner record) {
        record.setEditor("");
        record.setCreateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(2L);
        return bannerMapper.insert(record);
    }

    public int insertSelective(Banner record) {
        record.setEditor("");
        record.setCreateAt(System.currentTimeMillis());
        record.setUpdateAt(System.currentTimeMillis());
        record.setCreateBy(1L);
        record.setUpdateBy(2L);
        return bannerMapper.insertSelective(record);
    }

    public List<Banner> selectByExample(BannerExample example) {
        return bannerMapper.selectByExample(example);
    }

    public Banner selectByPrimaryKey(Long id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Banner record) {
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(2L);
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Banner record) {
        record.setUpdateAt(System.currentTimeMillis());
        record.setUpdateBy(2L);
        return bannerMapper.updateByPrimaryKey(record);
    }
}
