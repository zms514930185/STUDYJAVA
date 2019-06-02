import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.oasisopen.sca.NoSuchServiceException;
import service.CalculatorInterface;
import service.impl.Calculator;

import java.rmi.RMISecurityManager;


public class TestMain {
    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("service启动");
//        CalculatorInterface c = node.getService(Calculator.class, "CalculatorServiceComponent");
//        System.out.println(c.add(2, 2));
//        System.out.println("3 + 2 = " + c.add(3, 2));
//        System.out.println("3 - 2 = " + c.subtract(3, 2));
//        System.out.println("3 * 2 = " + c.multiply(3, 2));
//        System.out.println("3 / 2 = " + c.divide(3, 2));
//        node.stop();
    }
}
