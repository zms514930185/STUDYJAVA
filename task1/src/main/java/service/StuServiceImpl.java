package service;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StudentDao studentDao;

    public void addStu(Student stu) {
        studentDao.addStu(stu);
    }

    public void addByBatch(List list){
        studentDao.batchAdd(list);
    }
    public List<Student> selectByJob(String job){
        return studentDao.selectByJob(job);
    }
    public void deleteById(Integer id){
        studentDao.deleteById(id);
    }
    public int updateById(Student stu){
        return studentDao.updateById(stu);
    }
    public List<Student> selectByIdAndName(Student stu){
        return  studentDao.selectByIdAndName(stu);

    }
}
