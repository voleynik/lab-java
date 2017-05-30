package lab.poc.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpComparator implements Comparator {
  public int compare(Object obj1, Object obj2) {
    Person emp1 = (Person) obj1;
    Person emp2 = (Person) obj2;

    int nameComp = emp1.getFirstName().compareTo(emp2.getFirstName());

    return ((nameComp == 0) ? emp1.getLastName().compareTo(
        emp2.getLastName()) : nameComp);
  }

  public static void main(String args[]) {
    String names[] = { "Roy", "Bart", "Hugo", "Lisa", "Marge", "Homer", "Maggie" };

    // Convert to list
    List list = new ArrayList(Arrays.asList(names));

    // Ensure list sorted
    Collections.sort(list);
    System.out.println("Sorted list: [length: " + list.size() + "]");
    System.out.println(list);

    // Search for element in list
    int index = Collections.binarySearch(list, "Maggie");
    System.out.println("Found Maggie @ " + index);

    // Search for element not in list
    index = Collections.binarySearch(list, "Jimbo Jones");
    System.out.println("Didn't find Jimbo Jones @ " + index);

    // Insert
    int newIndex = -index - 1;
    list.add(newIndex, "Jimbo Jones");
    System.out.println("With Jimbo Jones added: [length: " + list.size()
        + "]");
    System.out.println(list);

    // Min should be Bart
    System.out.println(Collections.min(list));
    // Max should be Roy
    System.out.println(Collections.max(list));

    Comparator comp = Collections.reverseOrder();

    // Reversed Min should be Roy
    System.out.println(Collections.min(list, comp));
    // Reversed Max should be Bart
    System.out.println(Collections.max(list, comp));
  }
}