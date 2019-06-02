package service.impl;

import org.oasisopen.sca.annotation.Reference;
import org.springframework.stereotype.Service;
import service.*;

@Service
public class Calculator implements CalculatorInterface {
    private AddInterface add;
    private SubtractInterface subtract;
    private MultiplyInterface multiply;
    private DivideInterface divide;

    public AddInterface getAdd() {
        return add;
    }
    @Reference
    public void setAdd(AddInterface add) {
        this.add = add;
    }

    public SubtractInterface getSubtract() {
        return subtract;
    }
    @Reference
    public void setSubtract(SubtractInterface subtract) {
        this.subtract = subtract;
    }

    public MultiplyInterface getMultiply() {
        return multiply;
    }
    @Reference
    public void setMultiply(MultiplyInterface multiply) {
        this.multiply = multiply;
    }

    public DivideInterface getDivide() {
        return divide;
    }
    @Reference
    public void setDivide(DivideInterface divide) {
        this.divide = divide;
    }

    public double add(double n1, double n2) {
        return n1+n2;
    }

    public double divide(double n1, double n2) {
        try {
            return n1 / n2;
        } catch (Exception e) {
            return 0;
        }
    }

    public double subtract(double n1, double n2) {
        return n1-n2;
    }

    public double multiply(double n1, double n2) {
        return n1*n2;
    }
}
