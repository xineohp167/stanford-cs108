import java.awt.Point;

public class CallByValueChange {

	public static void notChange(MyPoint a) {
		System.out.println("ax=" + a.x + ";ay=" + a.y);
		a = new MyPoint(5,5);
		System.out.println("ax=" + a.x + ";ay=" + a.y);
	}
	
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1,1);
		
		notChange(p);
		System.out.println("x=" + p.x + ";y=" + p.y);
		p = change(p);
		System.out.println("x=" + p.x + ";y=" + p.y);
		p = new MyPoint(11,11);
		System.out.println("x=" + p.x + ";y=" + p.y);
	}

	private static MyPoint change(MyPoint p) {
		return new MyPoint(10,10);
		
	}
}
