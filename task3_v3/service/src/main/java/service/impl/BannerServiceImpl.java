package service.impl;

import org.springframework.stereotype.Service;
import pojo.Banner;
import pojo.BannerExample;
import service.BannerService;

import java.util.List;
@Service
public class BannerServiceImpl implements BannerService {
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Banner record) {
        return 0;
    }

    public int insertSelective(Banner record) {
        return 0;
    }

    public List<Banner> selectByExample(BannerExample example) {
        return null;
    }

    public Banner selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Banner record) {
        return 0;
    }

    public int updateByPrimaryKey(Banner record) {
        return 0;
    }
}
