package service;

import org.apache.ibatis.annotations.Param;
import pojo.Company;
import pojo.CompanyExample;

import java.util.List;

public interface CompanyService {
//    int deleteByPrimaryKey(Long id);

//    int insert(Company record);

//    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

//    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

//    int updateByPrimaryKeySelective(Company record);

//    int updateByPrimaryKey(Company record);
}