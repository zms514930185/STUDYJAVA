package service.impl;

import dao.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Reply;
import pojo.ReplyExample;
import service.ReplyService;

import java.util.List;
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    public int deleteByPrimaryKey(Long id) {
        return replyMapper.deleteByPrimaryKey(id);
    }

    public int insert(Reply record) {
        record.setCreateAt(System.currentTimeMillis());

        return replyMapper.insert(record);
    }

    public int insertSelective(Reply record) {
        record.setCreateAt(System.currentTimeMillis());
        return replyMapper.insertSelective(record);
    }

    public List<Reply> selectByExample(ReplyExample example) {
        return replyMapper.selectByExample(example);
    }

    public Reply selectByPrimaryKey(Long id) {
        return replyMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Reply record) {
        return replyMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Reply record) {
        return replyMapper.updateByPrimaryKey(record);
    }
}
