package lab.interkassa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Node extends Component{

	LinkedList<Component> leaves = new LinkedList<Component>();
	
	@Override
	public void addComponent(Component c) {
		leaves.add(c);	
	}

	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public void setWeight(int w) {
		// not needed	
	}

	@Override
	public LinkedList getChildren() {
		return leaves;
	}	
}
