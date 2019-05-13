package service.impl;

import dao.ExcellenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Excellence;
import pojo.ExcellenceExample;
import service.ExcellenceService;

import java.util.List;

@Service
public class ExcellenceServiceImpl implements ExcellenceService {

  @Autowired
  ExcellenceMapper em;

    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Excellence record) {
        return 0;
    }

    public int insertSelective(Excellence record) {
        return 0;
    }

    public List<Excellence> selectByExample(ExcellenceExample example) {
        return em.selectByExample(example);
    }

    public Excellence selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByExampleSelective(Excellence record, ExcellenceExample example) {
        return 0;
    }

    public int updateByExample(Excellence record, ExcellenceExample example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(Excellence record) {
        return 0;
    }

    public int updateByPrimaryKey(Excellence record) {
        return 0;
    }
}
