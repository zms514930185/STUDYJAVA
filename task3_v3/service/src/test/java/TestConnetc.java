//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import pojo.User;
//import pojo.UserExample;
//import service.UserService;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//public class TestConnetc {
//
//    @Autowired
//    UserService us;
//
//    @Test
//    public void connect(){
//        UserExample example = new UserExample();
//        UserExample.Criteria criteria = example.createCriteria();
//
//
//        List<User> list=us.selectByExample(example);
//        System.out.println(list);
//    }
//}
