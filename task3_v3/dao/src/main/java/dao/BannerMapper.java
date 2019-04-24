package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import pojo.Banner;
import pojo.BannerExample;
@Repository
public interface BannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExample(BannerExample example);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}