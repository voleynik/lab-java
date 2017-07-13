package lab.interkassa;

import java.util.Arrays;
import java.util.LinkedList;

public class Processor {
	
	private static int maxWeight = 3;
	private static LinkedList<Component> extras;

	public static void process(Component c) {
		
		if(c instanceof lab.interkassa.Node){
			
			LinkedList<Component> children = c.getChildren();
			if(children != null && children.isEmpty() == false){
				
			}		
		}
		
		
		
		LinkedList<Component> children = c.getChildren();
		if(extras != null){
			children.addAll(extras);   
		}
		
		for( int i = 0; i < c.getChildren().size(); i++ ){	  
			
			Component temp = (Component) c.getChildren().get(i);
			
			if(temp.getChildren() != null){// Node
				
			}
			
			process( (Component) c.getChildren().get(i), newExtras );       
		}
		
		
		if(c.getChildren() != null){
			   	   
			   
			   Component[] arrChildren = new Component[children.size()];
			   Arrays.sort(arrChildren, new WeightComparator());
			   
			   LinkedList<Component> newExtras = new LinkedList<Component>();
			   
			   int sumWeight = 0;
			   
			   
			   
		   }

	}

}
