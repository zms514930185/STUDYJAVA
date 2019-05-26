package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiServer {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","101.132.156.239");
//        System.setProperty("java.rmi.server.hostname","35.200.113.38");
//        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        System.out.println("RMI服务伴随Spring的启动而启动了.....");
    }
}
