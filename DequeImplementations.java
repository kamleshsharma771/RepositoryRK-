package revision.collection;

import java.util.ArrayDeque;
import java.util.Iterator;

public class DequeImplementations {
	public static void main(String...args){
		ArrayDeque<String> arrayDeque = new ArrayDeque<>();
		
		arrayDeque.add("first");
		arrayDeque.add("second");
		arrayDeque.add("third");
		arrayDeque.add("fourth");
		arrayDeque.add("fifth");
		
		System.out.println(arrayDeque);
		
		for(Iterator<String> i = arrayDeque.iterator(); i.hasNext();){
			System.out.print(i.next() + " ");
			arrayDeque.removeAll(arrayDeque);
		}	
	}
}
