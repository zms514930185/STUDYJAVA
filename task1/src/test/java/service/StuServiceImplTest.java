package service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.StuRandom;
import pojo.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StuServiceImplTest {
    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    StuService ssi = (StuService) ctx.getBean("stuServiceImpl");
    Student stu=new Student();
    StuRandom stuRandom=new StuRandom();


    @Test
    public void addStu() {
        for (int i = 0; i < 1000; i++) {
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
    }

    @Test
    public void addByBatch(){
        List<Student> list=new ArrayList<Student>();
        Long starttime=System.currentTimeMillis();
        for(int j=0;j<300;j++){

        for (int i = 0; i < 100000; i++) {
            Student stu=new Student();
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
            list.add(stu);
        }
        ssi.addByBatch(list);
        list.clear();
        }
        Long endtime=System.currentTimeMillis();
        System.out.println("####################################");
        System.out.println("一共使用的时间是："+(endtime-starttime));

    }


    @Test
    public void selectByJob(){
        List<Student> list=new ArrayList<Student>();
        list=ssi.selectByJob("动画师");
//        System.out.println(list);
//        System.out.println("################################################");
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
        System.out.println("################################################");
        for (int i=0;i<=list.size()-1;i++) {
            System.out.println(list.get(i));
        }
        System.out.println("################################################");
        System.out.println("总共有："+"\t"+list.size()+"人");
    }

    @Test
    public void deleteById(){
        ssi.deleteById(38000194);
    }

    @Test
    public void updateById(){
        stu.setsName("粉笔小新");
        stu.setJob(null);
        stu.setQq(null);
        stu.setId(3800099);
        ssi.updateById(stu);
    }
    @Test
    public void selectByIdAndName(){
        List<Student> list=new ArrayList<Student>();
        stu.setsName("小新");
        stu.setId(null);
        list=ssi.selectByIdAndName(stu);
        for (Student stu :list){
        System.out.println(stu);
        }
    }



}