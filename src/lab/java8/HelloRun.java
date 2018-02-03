package lab.java8;

public class HelloRun {

    public static void main(String[] args) {

        ////////////////// A - Traditional
        Hello h1 = new HelloImpl();
        h1.hello("Bill");

        ////////////////// B - Anonimous class. 5 lines. No Impl needed
        Hello h2 = new Hello() {
            public void hello(String name) {
                System.out.println("Hello " + name);
            }
        };
        h2.hello("Steve");

        ////////////////// C - Lambda 3 lines. No Impl needed
        Hello h3 = (name) -> {
            System.out.println("Hello " + name);
        };
        h3.hello("Vlad");
    }
}
