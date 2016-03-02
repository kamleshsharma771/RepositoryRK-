package revision.collection.concurrent;

import  java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlocking {
	public static void main(String...args){
		PriorityBlockingQueue queue = new PriorityBlockingQueue();
		queue.add(24);
		queue.add(14);
		queue.add(140);
		queue.add(0);
		queue.add(900);	
		
		System.out.println("queue: " + queue);
	}
}
