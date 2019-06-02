package main;

import service.CalculatorInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class CliMain {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        CalculatorInterface c = (CalculatorInterface) Naming.lookup("rmi://127.0.0.1:8090/CalculatorRMI");
        System.out.println(c.add(2, 2));
        System.out.println("3 + 2 = " + c.add(3, 2));
        System.out.println("3 - 2 = " + c.subtract(3, 2));
        System.out.println("3 * 2 = " + c.multiply(3, 2));
        System.out.println("3 / 2 = " + c.divide(3, 2));
    }
}
