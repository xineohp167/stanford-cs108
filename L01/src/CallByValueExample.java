
public class CallByValueExample {

	public static void increment(int a) {
		a++;
	}
	
	public static void main(String[] args) {
		int x = 1;
		
		increment(x);
		System.out.println(x);
	}
}
