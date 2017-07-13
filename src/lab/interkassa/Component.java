package lab.interkassa;

public abstract class Component {

	public abstract void addLeaf(Component c);
	public abstract int getWeight();
	public abstract void setWeight(int w);
	
	String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
