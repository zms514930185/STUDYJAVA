package service;

import pojo.Student;

import java.util.List;

public interface StuService {
    int addStu(Student stu);

    int delete(Student stu);

    List<Student> list();

    int update(Student stu);

    Student select(int id);

    int deleteaMany(int[] id_arr);

}
