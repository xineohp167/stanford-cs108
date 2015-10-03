
public class MyPoint {
	public int x;
	public int y;
	
	public MyPoint(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	// Copy constructor
	public MyPoint(MyPoint p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public boolean equals(MyPoint p) {
		return (x == p.x) && (y == p.y);
	}
	
	@Override
	public String toString() {
		return "point(" + x + "," + y + ")";
	}
}
