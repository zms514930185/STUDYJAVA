package service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@SuppressWarnings("Duplicates")
@Component
public class RmiChoose {
    Logger logger = Logger.getLogger(RmiChoose.class);
    @Qualifier("company01")
    @Autowired
    CompanyService companyService01;
    @Qualifier("excellence01")
    @Autowired
    ExcellenceService excellenceService01;
    @Qualifier("jobService01")
    @Autowired
    JobService jobService01;
    @Qualifier("userService01")
    @Autowired
    UserService userService01;
    @Qualifier("helloService01")
    @Autowired
    HelloService helloService01;

    @Qualifier("company02")
    @Autowired
    CompanyService companyService02;
    @Qualifier("excellence02")
    @Autowired
    ExcellenceService excellenceService02;
    @Qualifier("jobService02")
    @Autowired
    JobService jobService02;
    @Qualifier("userService02")
    @Autowired
    UserService userService02;
    @Qualifier("helloService02")
    @Autowired
    HelloService helloService02;

     public CompanyService getCompanyService() {
         Integer random = new Random().nextInt(2);
         System.out.println(random);
         if (0 == random) {
             try {
//                 logger.info("#判断1号服务是否可用");
                 //判断1号服务是否可用
                 helloService01.hello();
//                 logger.info("#启用companyService01");
                 return companyService01;
             } catch (Exception e) {
//                 logger.info("#捕获1号服务不可用");
//                 logger.info("#启用companyService02");
                 return companyService02;
             }
         }else {
             try {
//                 logger.info("#判断2号服务是否可用");
                 //判断2号服务是否可用
                 helloService02.hello();
//                 logger.info("#启用companyService02");
                 return companyService02;
             } catch (Exception e) {
//                 logger.info("#捕获2号服务不可用");
//                 logger.info("#启用companyService01");
                 return companyService01;
             }
         }
     }

    public ExcellenceService getExcellenceService() {
        Integer random = new Random().nextInt(2);
        if (0 == random) {
            try {
                helloService01.hello();
                return excellenceService01;
            } catch (Exception e) {
                return excellenceService02;
            }
        }else {
            try {
                helloService02.hello();
                return excellenceService02;
            } catch (Exception e) {
                return excellenceService01;
            }
        }
    }

    public JobService getJobService() {
        Integer random = new Random().nextInt(2);
        if (0 == random) {
            try {
                helloService01.hello();
                return jobService01;
            } catch (Exception e) {
                return jobService02;
            }
        }else {
            try {
                helloService02.hello();
                return jobService02;
            } catch (Exception e) {
                return jobService01;
            }
        }
    }

    public UserService getUserService() {
        Integer random = new Random().nextInt(2);
        if (0 == random) {
            try {
                helloService01.hello();
                return userService01;
            } catch (Exception e) {
                return userService02;
            }
        }else {
            try {
                helloService02.hello();
                return userService02;
            } catch (Exception e) {
                return userService01;
            }
        }
    }
    public HelloService getHelloService() {
        Integer random = new Random().nextInt(2);
        if (0 == random) {
            try {
                helloService01.hello();
                return helloService01;
            } catch (Exception e) {
                return helloService02;
            }
        }else {
            try {
                helloService02.hello();
                return helloService02;
            } catch (Exception e) {
                return helloService01;
            }
        }
    }
}
