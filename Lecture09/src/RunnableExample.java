
public class RunnableExample implements Runnable {

	@Override
	public void run() {
		System.out.println("I am ALIVE!");		
	}
	
	public static void main(String[] args) {
		Thread a = new Thread(new RunnableExample());
		a.start();
	}

}
