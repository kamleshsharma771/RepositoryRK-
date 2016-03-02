package revision.collection.concurrent;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.LinkedTransferQueue;

//demonstrating the LinkedTransferQueue, BlockingDeque 

public class BlockingCollections {
	public static void main(String...args){
		
		//LinkedTransferQueue
		LinkedTransferQueue<String> transferQueue = new LinkedTransferQueue<>();
		String element = "data";
		Consumer<String> consumer = new Consumer(transferQueue);
		Producer<String> producer = new Producer(transferQueue,element);
		
		Thread consumerThread1 = new Thread(consumer,"consumer1");
		Thread consumerThread2 = new Thread(consumer,"consumer2");
		Thread producerThread = new Thread(producer);
		
		consumerThread1.start();
		consumerThread2.start();
		
		producerThread.start();
	
	}
}

class Consumer<E> implements Runnable{
	private LinkedTransferQueue<E> blockingQueue;
	public Consumer(LinkedTransferQueue<E> bq) {
		blockingQueue  = bq;
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(200);

				System.out.println(Thread.currentThread().getName() + " : got " + blockingQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Producer<E> implements Runnable{
	private LinkedTransferQueue<E> blockingQueue;
	private E element ;
	public Producer(LinkedTransferQueue<E> bq, E data) {
		blockingQueue  = bq;
		element = data;
		
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(3000);
				System.out.println("Producer: " + " Waiting consumers: " + blockingQueue.hasWaitingConsumer()+ " | got " + blockingQueue.getWaitingConsumerCount() + " consumers");
				blockingQueue.transfer(element);
				System.out.println("Producer: " + element + " inserted");
				}catch (InterruptedException e) {
					e.printStackTrace();
			}
		}
	}
}