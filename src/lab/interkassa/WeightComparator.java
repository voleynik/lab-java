package lab.interkassa;

import java.util.Comparator;

public class WeightComparator implements Comparator<Component> {

		    public int compare(Component o1, Component o2) {
		        return (o1.getWeight() - o2.getWeight());
		    }
}
