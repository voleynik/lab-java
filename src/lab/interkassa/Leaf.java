package lab.interkassa;

import java.util.LinkedList;

public class Leaf extends Component{

	int weight;
	
	@Override
	public void addComponent(Component c) {
		// not needed
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public void setWeight(int w) {
		weight = w;
	}
	
	@Override
	public LinkedList getChildren() {
		return null;
	}
}
