package service;

import dao.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

    @Override
    public int addStu(Student stu) {
        stu.setCreateAt(System.currentTimeMillis());
        stu.setUpdateAt(System.currentTimeMillis());
        return stuMapper.addStu(stu);

    }

    @Override
    public int delete(Student stu) {
        return stuMapper.delete(stu);
    }

    @Override
    public List<Student> list() {
        return stuMapper.list();
    }

    @Override
    public int update(Student stu) {
        stu.setUpdateAt(System.currentTimeMillis());
        return stuMapper.update(stu);
    }

    @Override
    public Student select(int id) {
        return stuMapper.select(id);
    }
}
