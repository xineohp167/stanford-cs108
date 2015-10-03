
public class StringComparison {
	
	public static void main(String[] args) {
		
		String s1 = new String("Stanford");
		String s2 = new String("Stanford");

		String s3 = "Test";
		String s4 = "Test";
		
		System.out.println("s1 == s2: " + (s1 == s2));
		System.out.println("s1.equals(s2): " + s1.equals(s2));

		System.out.println("s3 == s4: " + (s3 == s4));
		System.out.println("s3.equals(s4): " + s3.equals(s4));

	}
}
