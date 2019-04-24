import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.TableName;
import service.IsExist;
import service.TableNameService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {

    @Autowired
    TableNameService tns;
    @Autowired
    IsExist isExist;

    Logger logger = Logger.getLogger(test.class);
    @Test
    public void test(){
        TableName tableName = new TableName("user","username","产品10");
        logger.info("[logger]"+tableName);
        Object i=tns.selectByExample(tableName);
        System.out.println("i:"+i);
    }

    @Test
    public void testExist(){

        TableName tableName = new TableName("user","username","产品6");
        logger.info("[logger]\t"+tableName);

        boolean i=isExist.exist(tableName);
        System.out.println("[logger]"+i);

    }
}
