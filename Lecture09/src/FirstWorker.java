/*
 Demonstrates creating a couple worker threads, running them,
 and waiting for them to finish.
 
 Threads respond to a getName() method, which returns a string
 like "Thread-1" which is handy for debugging.
*/
class FirstWorker extends Thread {
	@Override
	public void run() {
		long sum = 0;
		for (int i=0; i<10000000; i++) {
			sum = sum + i;	// do some work

			// every n iterations, print an update
			// (a bitwise & would be faster -- mod is slow)
			if (i%1000000 == 0) {
				Thread running = Thread.currentThread();
				System.out.println(running.getName() + " " + i);
			}
		}
	}

	
	public static void main(String[] args) {
		FirstWorker a = new FirstWorker();
		FirstWorker b = new FirstWorker();
		
		System.out.println("Starting...");
		a.start();
		b.start();
		
		// The current running thread (executing main()) blocks
		// until both workers have finished
		try {
			a.join();
			b.join();
		}
		catch (Exception ignored) {}
		
		System.out.println("All done");
	}
	/*
		Starting...
		Thread-0 0
		Thread-0 10000
		Thread-0 20000
		Thread-1 0
		Thread-1 10000
		Thread-0 30000
		Thread-0 40000
		Thread-1 20000
		Thread-0 50000
		Thread-1 30000
		Thread-0 60000
		Thread-1 40000
		Thread-0 70000
		Thread-1 50000
		Thread-0 80000
		Thread-1 60000
		Thread-0 90000
		Thread-1 70000
		Thread-1 80000
		Thread-1 90000
		All done
	*/
}
