package service.impl;

import org.springframework.stereotype.Service;
import service.MultiplyInterface;
@Service
public class MultiplyInterfaceImpl implements MultiplyInterface {
    public double multiply(double n1, double n2) {
        return n1*n2;
    }
}
