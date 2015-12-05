import java.util.Random;
import java.util.concurrent.*;

public class SemaphoreExample {

	static final int NUM_THREADS = 7;
	
	static final int NUM_PRINTERS = 3;
	static Semaphore printerSemaphore;
	
	static class WorkThread extends Thread {
		public void run() {
			// do some stuff which may or may not need the printer
			Random rnd = new Random();
			for (int i=0; i<1000; i++) {
				if (rnd.nextInt(100) == 0) {
					System.out.println(getName() + " needs Printer");
					try {
						printerSemaphore.acquire();
						System.out.println(getName() + " got Printer");
						
						try {  // take up some time simulating printing
							   // this has its own try catch block if it shared
							   // the acquire's try catch block, an interruption 
							   // here might result in the printer semaphore not 
							   // being released
						   sleep(3000);  	
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						System.out.println(getName() + " done with Printer");
						printerSemaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(getName() + " all done");
		}
	}
	
	public static void main(String[] args) {
		printerSemaphore = new Semaphore(NUM_PRINTERS);
		
		for(int i=0; i< NUM_THREADS; i++) {
			new WorkThread().start();
		}
	}
}
