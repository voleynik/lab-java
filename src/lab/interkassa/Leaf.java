package lab.interkassa;

public class Leaf extends Component{

	int weight;
	
	@Override
	public void addLeaf(Component c) {
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

}
