package lab.pzl;

import java.util.ArrayList;
import java.util.List;

public class RemoveFromLinkedList {
	
	public static int numObj = 4;
	
	public static void main(String[] args) {
		List likedList = buildList();
		System.out.println("BEFORE");
		printList(likedList);
		removeObj( likedList, 2 );
		System.out.println("AFTER");
		printList(likedList);
	}
	
	private static void removeObj( List list, int i ){
		
		System.out.println("REMOVING # " + i + "\n");
		if ( i < 0 || i >= list.size() ) {
			System.out.println("Obj # " + i + " does not exist! \n");
			return;
		}
		
		LinkedObj oB, oA = null;
		
		if( i > 0 ){
			oB = (LinkedObj) list.get( i - 1 );
		}else {
			oB = null;
		}
		if( i <= (list.size() - 1) ){
			oA = (LinkedObj) list.get( i + 1 );
		}else {
			oA = null;
		}
		
		if(oB != null){
			oB.oA = oA;
		}
		if(oA != null){
			oA.oBefore = oB;
		}
		list.remove(i);
	}
	
	private static List buildList(){
		List list = new ArrayList();
		LinkedObj oB, o, oA = null;
		
		for (int i = 0; i < numObj; i++) {
			
			o = new LinkedObj();
		
			if( i == 0 ) {
				o.oBefore = null;
			} else {
				oB = (LinkedObj) list.get( i - 1 );
				o.oBefore = oB;
				oB.oA = o;
			}      
			
			o.oA = null;
     
			o.objName = "obj" + i;
			list.add( o );
		}
		
		return list;
	}
	
	public static void printList(List likedList){
		
		for (int i = 0; i < likedList.size(); i++) {
			System.out.println( likedList.get(i) );
		}
	}
}
