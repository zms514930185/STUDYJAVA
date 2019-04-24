package service;

import pojo.Reply;
import pojo.ReplyExample;

import java.util.List;

public interface ReplyService {
    int deleteByPrimaryKey(Long id);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}