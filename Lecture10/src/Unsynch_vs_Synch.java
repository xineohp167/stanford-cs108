import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class Unsynch_vs_Synch {
	
	static List<String> testList;
	static CountDownLatch latch;
	static AtomicInteger errorCount;
	
	static final int TESTNUM = 10000;
	
	static class TestListThread extends Thread {
		
		// add and remove items in the list, tracking number of errors
		public void run() {
			try {
				for(int i=0; i<TESTNUM; i++) {
					testList.add("Hello");
				}
				for(int i=0; i<TESTNUM; i++) {
					testList.remove(0);
				}
			} catch (Exception e) {
				System.out.println("Error");
				errorCount.incrementAndGet();
			}

			latch.countDown();
		}
	}
	
	public static void testThreadingSupport(int numThreads) {
		latch = new CountDownLatch(numThreads);
		errorCount = new AtomicInteger();
		
		for(int i=0; i< numThreads; i++) {
			new TestListThread().start();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
		}
		
		System.out.println(errorCount.get() + " Errors");
	}

	public static void main(String[] args) {
		
		System.out.println("Running with Standard Array List and One Thread");
		testList = new ArrayList<String>();
		testThreadingSupport(1);
		
		System.out.println("\nRunning with Standard Array List and Multiple Threads");
		testList = new ArrayList<String>();
		testThreadingSupport(8);
		
		// do the exact same thing but with a Synchronized List
		System.out.println("\nRunning with Synchronized ArrayList and Multiple Theads");
		testList = Collections.synchronizedList(new ArrayList<String>());
		testThreadingSupport(8);
	}

}
