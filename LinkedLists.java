package revision.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedLists {
	public static void main(String...args){
		LinkedList<String> linkedLists = new LinkedList<>();
		
		linkedLists.add("First");
		linkedLists.add("Second");
		linkedLists.add("Third");
		linkedLists.add("Fourth");
		linkedLists.add("Five");
		linkedLists.add("Fourth");
		linkedLists.add("Five");
		
		linkedLists.add(null);
		
		//Using as a queue
		linkedLists.poll();
		
		System.out.println(linkedLists);
		
		for(Iterator<String> i = linkedLists.iterator(); i.hasNext(); ){
			System.out.print(i.next() + ", ");
		}
		
		System.out.println("\nlast : " + linkedLists.getLast());
		System.out.println("\nfirst : " + linkedLists.getFirst());
		
		linkedLists.offer("First");
		
		System.out.println(linkedLists);
		
		for(Iterator<String> i = linkedLists.descendingIterator(); i.hasNext(); ){
			System.out.print(i.next() + ", ");
			linkedLists.addLast("");
		}
		
		linkedLists.removeFirstOccurrence("Five");
		linkedLists.removeLastOccurrence("Five");
		System.out.println("\n" + linkedLists);
	
	}
}