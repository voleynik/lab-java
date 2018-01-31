package lab.lambda;

public class OperatorTester {

    interface Operator {
        int operate(int a, int b);
    }

    public static void main(String[] args) {

        Operator opr = (x, y) -> x + y;

        System.out.println("10 + 5 = " + opr.operate(10, 5));
    }
}
