package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

import java.util.List;

import static org.junit.Assert.*;

public class stuServiceImplTest {
    ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
    StuService ss = (StuService) act.getBean("stuServiceImpl");
    Student stu=new Student();

    @Test
    public void addStu() {
        stu.setStuName("王王王");
        stu.setQq("123123456");
        stu.setJob("java");
        stu.setUpdateAt(System.currentTimeMillis());
        stu.setCreateAt(System.currentTimeMillis());
        ss.addStu(stu);

    }

    @Test
    public void delete() {
        stu.setId(10002);
        ss.delete(stu);
    }

    @Test
    public void list() {

        List<Student> list=ss.list();
        for(Student i:list){
            System.out.println(i);
        }

    }

    @Test
    public void update() {
        stu.setId(10001);
        stu.setStuName("王水");
        stu.setQq("4534565");
        stu.setJob("css");
        stu.setUpdateAt(System.currentTimeMillis());

        ss.update(stu);
    }
}