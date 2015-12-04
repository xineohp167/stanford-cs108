/*
 Demonstrates creating a couple worker threads, running them,
 interrupting them, and waiting for them to finish.
 In run(), increments a counter, prints something,
 and sleeps. Checks for interruption on each iteration.
*/
public class StopWorker extends Thread {
	
	@Override
	public void run() {
		long sum = 0;
		int count = 500;
		int i;
		for (i=0; i<count; i++) {
			sum = sum + i;	// do some work
			System.out.println(getName() + " " + i);
			
			// 1. Check interrupted boolean -> break
			if (isInterrupted()) {
				// clean up, exit when interrupted
				// (getName() returns a default name for each thread)
				System.out.println(getName() + " interrupted");
				break;
			}
			
			// 2. Sleep a little (simulate doing something slow)
			// InterruptedException -> break
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException ex) {
				break;
			}
			
			// We notice we are interrupted either
			// because isInterrupted() is true or because
			// we get an InterruptedException.
		}
		
		// Notice if we exited the loop due to interruption.
		if (i < count) {
			System.out.println(getName() + " interrupted " + i);
		}
	}
	
	public static void main(String[] args) {
		StopWorker a = new StopWorker();
		StopWorker b = new StopWorker();
		
		System.out.println("Starting...");
		a.start();
		b.start();
		
		try {
			Thread.sleep(100);	// sleep a little, so they make some progress
		}
		catch (InterruptedException ignored) {
		}
		
		System.out.println("Sending interrupt()");
		a.interrupt();
		b.interrupt();

		try {
			a.join();
			b.join();
		}
		catch (InterruptedException ignored) {
			// could get here if someone interrupted the main() thread
		}
		
		System.out.println("All done");
	}
/*
   Starting...
	Thread-0 0
	Thread-1 0
	Thread-0 1
	Thread-1 1
	Thread-0 2
	Thread-1 2
	Thread-0 3
	...
	Thread-1 116
	Thread-0 117
	Thread-1 117
	Sending interrupt()
	Thread-0 interrupted 117
	Thread-1 118
	Thread-1 interrupted 118
	All done
*/
}
