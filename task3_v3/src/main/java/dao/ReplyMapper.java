package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import pojo.Reply;
import pojo.ReplyExample;
@Repository
public interface ReplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}