package lab.java8;

public class TwoIntMathTester {

    interface TwoIntMath {
        int perform(int a, int b);
    }

    public static void main(String[] args) {

        TwoIntMath add = (x, y) -> x + y; // IF MORE THAN 1 PARM,  NEED PARENTHESES
        System.out.println("10 + 5 = " + add.perform(10, 5));

        TwoIntMath sub = (x, y) -> { return x - y;}; // {return ...}; -- optional
        System.out.println("10 - 5 = " + sub.perform(10, 5));

        TwoIntMath div = (x, y) -> {
            return x / y;
        };
        System.out.println("10 / 5 = " + div.perform(10, 5));
    }
}
