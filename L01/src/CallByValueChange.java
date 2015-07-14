import java.awt.Point;

public class CallByValueChange {

	public static void notChange(MyPoint a) {
		a = new MyPoint(5,5);
	}
	
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1,1);
		
		notChange(p);
		System.out.println("x=" + p.x + ";y=" + p.y);
		p = change(p);
		System.out.println("x=" + p.x + ";y=" + p.y);
	}

	private static MyPoint change(MyPoint p) {
		return new MyPoint(5,5);
		
	}
}
