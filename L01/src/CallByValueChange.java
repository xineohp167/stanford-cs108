import java.awt.Point;

public class CallByValueChange {

	public static void change(Point a) {
		a = new Point(5,5);
	}
	
	public static void main(String[] args) {
		Point p = new Point(1,1);
		
		change(p);
		System.out.println("x=" + p.x + ";y=" + p.y);
	}
}
