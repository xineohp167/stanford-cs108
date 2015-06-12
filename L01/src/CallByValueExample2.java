import java.awt.Point;

public class CallByValueExample2 {
	
	public static void increment(Point a) {
		a.x++;
		a.y++;
	}
	
	public static void main(String[] args) {
		Point p = new Point(1,1);
		
		increment(p);
		System.out.println("x=" + p.x + ";y=" + p.y);
	}
}
