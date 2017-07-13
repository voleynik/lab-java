package lab.interkassa;

import java.util.LinkedList;

import lab.poc.node.Node;

public abstract class Component {

	public abstract void addComponent(Component c);
	public abstract int getWeight();
	public abstract void setWeight(int w);
	public abstract LinkedList getChildren();
	
	String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
   public static void print(Component c){

	   System.out.println(c.getId());

	   if(c.getChildren() != null){

		   for( int i = 0; i < c.getChildren().size(); i++ ){	            
			   print( (Component) c.getChildren().get(i) );       
		   }
	   }
   	}
}
