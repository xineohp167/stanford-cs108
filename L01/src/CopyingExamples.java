public class CopyingExamples {
	
	public static void main(String[] args) {
		MyPoint p1 = new MyPoint(5,5);
		MyPoint p2 = p1;
		
		p2.x = 15;
		
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
		
		MyPoint q1 = new MyPoint(5,5);
		MyPoint q2 = new MyPoint(q1);
		
		q2.x = 15;
		
		System.out.println("q1 = " + q1);
		System.out.println("q2 = " + q2);
	}

}
