package revision.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.*;

public class CopyOnWriteSet {	
	public static void main(String...args){
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("DOg");
		arrayList.add("Apple");
		arrayList.add("Mango");
		arrayList.add("Zebra");
		arrayList.add("Bottle");
		arrayList.add("Bag");
		arrayList.add("Console");
		arrayList.add("Console");
		arrayList.add(null);
		
		CopyOnWriteArraySet<String> copyOnWriteArraySet  = new CopyOnWriteArraySet<>();
		copyOnWriteArraySet.addAll(arrayList);
		
		copyOnWriteArraySet.add("abcd123");
		copyOnWriteArraySet.add("install");
		copyOnWriteArraySet.add("software");
		copyOnWriteArraySet.add("updates");
		copyOnWriteArraySet.add("available");
		
		copyOnWriteArraySet.retainAll(arrayList);
		
		System.out.println(copyOnWriteArraySet);
		
		Iterator<String> iterator = copyOnWriteArraySet.iterator();
		
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
			copyOnWriteArraySet.add("unwanted");
			iterator.remove();
		}
		
		copyOnWriteArraySet.add("abcd123");
		copyOnWriteArraySet.add("install");
		copyOnWriteArraySet.add("software");
		copyOnWriteArraySet.add("updates");
		copyOnWriteArraySet.add("available");
		
		System.out.println("\nsize: " + copyOnWriteArraySet.size() + " \n" +copyOnWriteArraySet);
	} 
}
