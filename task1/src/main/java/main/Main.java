package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.StuRandom;
import pojo.Student;
import service.StuService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuService ssi = (StuService) ctx.getBean("stuServiceImpl");
        Student stu = new Student();
        StuRandom stuRandom = new StuRandom();

        for (int i = 0; i < 2; i++) {
            stu.setsName(stuRandom.getStuName());
            stu.setQq(stuRandom.getQq(4, 10));
            stu.setJob(stuRandom.getJob());
            Long created = stuRandom.createAt();
            Long updated = stuRandom.updateAt();
            if (created > updated) {
                updated = created;
            }
            stu.setCreateAt(created);
            stu.setUpdateAt(updated);
            ssi.addStu(stu);
        }
        System.out.println("########################################################################");
        System.out.println("已全部完成！");
    }
}
