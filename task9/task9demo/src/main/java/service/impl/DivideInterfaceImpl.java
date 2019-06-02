package service.impl;

import org.springframework.stereotype.Service;
import service.DivideInterface;
@Service
public class DivideInterfaceImpl implements DivideInterface {
    public double divide(double n1, double n2) {
        try {
            return n1 / n2;
        } catch (Exception e) {
            return 0;
        }
    }
}
