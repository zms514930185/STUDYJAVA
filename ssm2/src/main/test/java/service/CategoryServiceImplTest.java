package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Category;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryServiceImplTest {

    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    CategoryService cs= (CategoryService) ctx.getBean("categoryServiceImpl");


    @Test
    public void getlist() {
       List<Category> list =cs.getlist();
       for(Category i:list){
           System.out.println(i);
       }
    }

    @Test
    public void add(){
        Category category=new Category();
        for (int i=100;i<124;i++){
            category.setName("Category"+(i+1));
            cs.add(category);
        }
    }

}