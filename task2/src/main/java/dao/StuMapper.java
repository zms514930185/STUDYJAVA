package dao;

import org.springframework.stereotype.Repository;
import pojo.Student;

import java.util.List;

@Repository
public interface StuMapper {
    int addStu(Student stu);

    int delete(Student stu);

    List<Student> list();

    int update(Student stu);

    Student select(int id);

    int deleteMany(int[] id_arr);
}
