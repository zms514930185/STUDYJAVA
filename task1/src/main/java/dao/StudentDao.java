package dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.Student;

import java.util.List;

@Repository
public interface StudentDao {
     void  addStu(Student stu);
    void batchAdd(List list);
    List<Student> selectByJob(String job);
    void deleteById(Integer id);
    void updateById(Student stu);
    List<Student> selectByIdAndName(Student student);
}
