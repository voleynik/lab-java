package lab.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTests {

    public static void main(String[] args) {

        System.out.println("Random numbers: ");// forEach, limit
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        System.out.println("Get list of unique squares.");// distinct, collect
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);

        // Count empty strings
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        int count = ((int) strings.stream().filter(string -> string.isEmpty()).count());
        System.out.println("Get count of empty strings: " + count);// filter, count

        System.out.println("Sorted integers.");// sorted
        random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");// joining(", ")
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);

        // Statistics
        numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println("Numbers: " + numbers);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }
}
