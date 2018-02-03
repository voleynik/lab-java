package lab.java8;

import java.util.List;
import java.util.ArrayList;

public class Names {

    public static void main(String args[]) {
        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println); // :: static method reference
    }
}