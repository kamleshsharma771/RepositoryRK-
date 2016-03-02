package revision.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.*;

public class CopyOnWriteArrays {
	public static void main(String...args){
		ArrayList<String> arrayList = new ArrayList<>();
		
		CopyOnWriteArrayList<String> concurrentArrayList = new CopyOnWriteArrayList<>();
		arrayList.add("DOg");
		arrayList.add("Apple");
		arrayList.add("Mango");
		arrayList.add("Zebra");
		arrayList.add("Bottle");
		arrayList.add("Bag");
		arrayList.add("Console");
		arrayList.add(null);
		
		concurrentArrayList.addAll(arrayList);
	
		Iterator<String> iterator = concurrentArrayList.iterator();
		
		concurrentArrayList.add("DOg");
		concurrentArrayList.add("Bag");
		concurrentArrayList.add("Console");
		
		System.out.println(concurrentArrayList);
		
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
			concurrentArrayList.remove("DOg");
		}
		
		System.out.println("\n" + concurrentArrayList);

	}
}
