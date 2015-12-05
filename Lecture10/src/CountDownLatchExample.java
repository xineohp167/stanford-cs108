import java.util.concurrent.CountDownLatch;


public class CountDownLatchExample {

	static class FirstWorker extends Thread {
		@Override
		public void run() {
			long sum = 0;
			Thread running = Thread.currentThread();
			for (int i=0; i<10000000; i++) {
				sum = sum + i;	// do some work

				// every n iterations, print an update
				// (a bitwise & would be faster -- mod is slow)
				if (i%1000000 == 0) {
					System.out.println(running.getName() + " " + i);
				}
			}
			System.out.println(running.getName() + " is done.");
			latch.countDown();
		}
	}
	
	static CountDownLatch latch;

	public static void main(String[] args) {
		latch = new CountDownLatch(4);
		
		FirstWorker a = new FirstWorker();
		FirstWorker b = new FirstWorker();
		FirstWorker c = new FirstWorker();
		FirstWorker d = new FirstWorker();
		
		System.out.println("Starting...");
		a.start();
		b.start();
		c.start();
		d.start();
		
		// The current running thread (executing main()) blocks
		// until all workers have finished
		try {
			latch.await();
		}
		catch (InterruptedException ignored) {}
		
		System.out.println("All done");	}

}
