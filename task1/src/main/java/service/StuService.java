package service;


import pojo.Student;

import java.util.List;

public interface StuService {

     void  addStu(Student stu);
    void addByBatch(List list);
    List<Student> selectByJob(String job);
    void deleteById(Integer id);
    void updateById(Student stu);
    List<Student> selectByIdAndName(Student student);
}
