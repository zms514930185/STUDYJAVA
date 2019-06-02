package service.impl;

import org.springframework.stereotype.Service;
import service.SubtractInterface;
@Service
public class SubtractInterfaceImpl implements SubtractInterface {
    public double subtract(double n1, double n2) {
        return n1-n2;
    }
}
