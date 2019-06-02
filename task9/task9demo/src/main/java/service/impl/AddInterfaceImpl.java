package service.impl;

import org.springframework.stereotype.Service;
import service.AddInterface;
@Service
public class AddInterfaceImpl implements AddInterface {
    public double add(double n1, double n2) {
        return n1+n2;
    }
}
