package revision.collection.concurrent;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class Element implements Delayed{
	
	private String data;
	private long delay;
	
	public Element(String data, long delay){
		this.data = data;
		this.delay = delay;
	}

	@Override
	public int compareTo(Delayed obj) {
		if(this.delay > ((Element)obj).delay)
			return 1;
		if(this.delay < ((Element)obj).delay)
			return -1;
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = delay - System.currentTimeMillis();
		
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String toString(){
		return data + " / " + delay;
	}
}

public class DelayedQueue {
	public static void main(String...args){

		// Creates an instance of blocking queue using the DelayQueue.
		BlockingQueue queue = new DelayQueue();
		
		// Starting DelayQueue Producer to push some delayed objects to the queue 
		new DelayedProducer(queue).start();
		
		// Starting DelayQueue Consumer to take the expired delayed objects from the queue
		new DelayedConsumer("Consumer Thread-1", queue).start();
	}
}

class DelayedConsumer{
	private String name;

	private BlockingQueue queue;

	public DelayedConsumer(String name, BlockingQueue queue) {
		super();
		this.name = name;
		this.queue = queue;
	}

	private Thread consumerThread =  new Thread(new Runnable() {
	    public void run() {
            while (true) {
                try {
                    // Take elements out from the DelayQueue object.
                    Element object = (Element) queue.take();
                    System.out.printf("[%s] - Take object = %s%n",
                            Thread.currentThread().getName(), object);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
	});

	public void start(){
		this.consumerThread.setName(name);
		this.consumerThread.start();
	}

}



class DelayedProducer{
	// Creates an instance of blocking queue using the DelayQueue.
    private BlockingQueue queue;

	private final Random random = new Random();
	
	public DelayedProducer(BlockingQueue queue) {
		super();
		this.queue = queue;
	}
	
	private Thread producerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                  
                    // Put some Delayed object into the DelayQueue.
                    int delay = random.nextInt(10000);
                    Element object = new Element(
                            UUID.randomUUID().toString(), delay);

                    System.out.printf("Put object = %s%n", object);
                    queue.put(object);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }, "Producer Thread");
	
	public void start(){
		this.producerThread.start();
	}
}

