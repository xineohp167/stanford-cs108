//TPoint.java

package tetris;

/*
 This is just a trivial "struct" type class --
 it simply holds an int x/y point for use by Tetris,
 and supports equals() and toString().
 We'll allow public access to x/y, so this
 is not an object really.
 */
public class TPoint implements Comparable<TPoint> {
	public int x;
	public int y;

	// Creates a TPoint based in int x,y
	public TPoint(int x, int y) {
		// questionable style but convenient --
		// params with same name as ivars

		this.x = x;
		this.y = y;
	}

	// Creates a TPoint, copied from an existing TPoint
	public TPoint(TPoint point) {
		this.x = point.x;
		this.y = point.y;
	}

	// Standard equals() override
	public boolean equals(Object other) {
		// standard two checks for equals()
		if (this == other) return true;
		if (!(other instanceof TPoint)) return false;

		// check if other point same as us
		TPoint pt = (TPoint)other;
		return(x==pt.x && y==pt.y);
	}

	// Standard toString() override, produce
	// human-readable String from object
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	
	/**
	 * Compare two points first for x and after that for y.
	 * @param o the other point
	 * @return -1/0/1 based on the order
	 */
	@Override
	public int compareTo(TPoint o) {
		if(this.x < o.x){
			return -1;
		}else if(this.x > o.x){
			return 1;
		} else if(this.y < o.y){
			return -1;
		} else if(this.y > o.y){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * Immutable method that returns a new TPoint with swapped x and y
	 * @return new TPoint(y, x)
	 */
	public TPoint swapped(){
		return new TPoint(y, x);
	}
	
	/**
	 * Immutable method that returns a new TPoint which is the sum of this point and the addPoint
	 * @param addPoint the point to add
	 * @return new TPoint which is the sum of the points
	 */
	public TPoint translated(TPoint addPoint){
		return new TPoint(this.x + addPoint.x, this.y + addPoint.y);
	}
	
	
	/**
	 * Returns the new rotated point, computed it on formula:<br>
	 * x' = x*cos(theta) - y*sin(theta)<br>
	 * y' = x*sin(theta) + y*cos(theta)<br>
	 * @param angleInRadians the angle of rotation
	 * @return new rotated point
	 */
    public TPoint rotated(double angleInRadians)
    {
            double cos = Math.cos(angleInRadians), sin = Math.sin(angleInRadians);
            double rotatedX = cos * x - sin*y,
                       rotatedY = sin * x + cos*y;
            return new TPoint((int)Math.round(rotatedX),
                                              (int)Math.round(rotatedY));
    }
}
