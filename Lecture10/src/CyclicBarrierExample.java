import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	
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
			try {
				barrier.await();
			} catch (InterruptedException ignore) {
			} catch (BrokenBarrierException ignore) {
			}
			System.out.println(running.getName() + " is done.");
		}
	}
	
	static CyclicBarrier barrier;

	public static void main(String[] args) {
		barrier = new CyclicBarrier(4);
		
		FirstWorker a = new FirstWorker();
		FirstWorker b = new FirstWorker();
		FirstWorker c = new FirstWorker();
		FirstWorker d = new FirstWorker();
		
		System.out.println("Starting...");
		a.start();
		b.start();
		c.start();
		d.start();
		
/* uncomment this section and increment CyclicBarrier to 5 if you
 * want main thread to wait until worker threads are completed
 */
//		try {
//			barrier.await();
//		}
//		catch (InterruptedException ignored) {
//		} 
//		catch (BrokenBarrierException ignored) {
//		}
		
		System.out.println("Main done");
	}

}
