public class MyPoint3 {
	private double r;
	private double theta;
	
	public MyPoint3(int x,int y) {
		this.r = Math.sqrt(x * x + y * y);
		theta = Math.atan( (double) y / x);
	}
	
	public long getX() {
		return Math.round(r * Math.cos(theta));
	}
	
	public long getY() {
		return Math.round(r * Math.sin(theta));
	}
	
}
