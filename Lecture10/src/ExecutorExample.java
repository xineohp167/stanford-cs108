import java.util.concurrent.*;

public class ExecutorExample {
	// we have more tasks that need to be carried out than can be efficiently
	// run at once
	static final int TASKS_NEEDED = 40;
	static final int MAX_RUNNING_THREADS = 10;
	
	static class WorkTask implements Runnable {
		int id; // id and constructor just so we can print out id numbers
				// when task is completed
		
		WorkTask(int id) {
			this.id = id;
		}
		
		public void run() {
			try { // go off and do some stuff
			   Thread.sleep(1500);  	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(id + " done");
		}
	}

	public static void main(String[] args) {
		Executor exec = Executors.newFixedThreadPool(MAX_RUNNING_THREADS);
		  // Changing this line changes our execution model.  Try replacing it with
		  // this for example:
		// Executor exec = Executors.newSingleThreadExecutor();
		
		for (int i=0; i<TASKS_NEEDED; i++) {
			exec.execute(new WorkTask(i));
		}
	}
}
