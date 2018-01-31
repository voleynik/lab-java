package lab.lambda;

public class Java8Tester {

    // 1. Static variable with doMath() imiplementation
    static MathOperation doAdd = (a, b) -> a + b;

    static class MathOperationImpl implements MathOperation{
        public int doMath(int a, int b){
            return a + b;
        }
    }
    interface MathOperation {
        int doMath(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.doMath(a, b);
    }

    public static void main(String args[]) {
        Java8Tester tester = new Java8Tester();

        // 2. Impl
        MathOperation mo = new MathOperationImpl();

        // 3. with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        // 4. with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        // 5. with return statement along with curly braces
        //MathOperation multiplication = (int a, int b) -> { return a * b; };
        MathOperation multiplication = (int a, int b) -> a * b; ;

        // 6. without return statement and without curly braces"
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("static: 10 + 5 = " + doAdd.doMath(10, 5));      // 1
        System.out.println("Impl: 10 + 5 = " + mo.doMath(10, 5));           // 2
        System.out.println("lambda: 10 + 5 = " + tester.operate(10, 5, addition));// 3
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));// 4
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));// 5
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));// 6

        //without parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //with parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
    }
}