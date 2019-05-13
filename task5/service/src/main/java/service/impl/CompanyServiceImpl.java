package service.impl;

import dao.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Company;
import pojo.CompanyExample;
import service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper cm;
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Company record) {
        return 0;
    }

    public int insertSelective(Company record) {
        return 0;
    }

    public List<Company> selectByExample(CompanyExample example) {
        return cm.selectByExample(example);
    }

    public Company selectByPrimaryKey(Long id) {
        return cm.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(Company record, CompanyExample example) {
        return 0;
    }

    public int updateByExample(Company record, CompanyExample example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(Company record) {
        return 0;
    }

    public int updateByPrimaryKey(Company record) {
        return 0;
    }
}
