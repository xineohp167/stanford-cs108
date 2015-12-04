
public class AnonRunnable {
	
	public static void main(String[] args) {
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I am ALIVE!");		
			}			 
		});
		a.start();
	}

}
