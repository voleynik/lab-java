package lab.poc.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WordCounter {

	static HashMap hm = new HashMap();
	
	public static void main(String[] args) {
		
		Collection cln = hm.values();
		Object[] arObj = cln.toArray();
		List list = new ArrayList(Arrays.asList(arObj));	
		
		System.out.println("\n Un Sorted list: [length: " + list.size() + "]");
		printList(list);
		
		Collections.sort(list);
		System.out.println("\n Sorted list: [length: " + list.size() + "]");
		printList(list);
		
		Collections.reverse(list);
		System.out.println("\n Reversed list: [length: " + list.size() + "]");
		printList(list);

	}
	
	private static void printList(List list){
		Word w = null;
		for (int i = 0; i < list.size(); i++) {
			w = (Word)list.get(i);
			System.out.println("Word: " + w.wrd + " - Count: " + w.ctr);
		}
	}

	static{
		hm.put("aaa", new Word("aaa", 999));
		hm.put("ccc", new Word("ccc", 777));
		hm.put("ddd", new Word("ddd", 666));
		hm.put("bbb", new Word("bbb", 888));
	}
}
