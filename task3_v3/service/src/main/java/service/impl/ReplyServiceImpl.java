package service.impl;

import org.springframework.stereotype.Service;
import pojo.Reply;
import pojo.ReplyExample;
import service.ReplyService;

import java.util.List;
@Service
public class ReplyServiceImpl implements ReplyService {
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Reply record) {
        return 0;
    }

    public int insertSelective(Reply record) {
        return 0;
    }

    public List<Reply> selectByExample(ReplyExample example) {
        return null;
    }

    public Reply selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Reply record) {
        return 0;
    }

    public int updateByPrimaryKey(Reply record) {
        return 0;
    }
}
