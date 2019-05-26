package service.impl;

import org.springframework.stereotype.Service;
import service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    public String hello() {
        return "Test Connect";
    }
}
