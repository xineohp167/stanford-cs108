// Grad.java/* Grad is a subclass of Student -- a simple example of subclassing. -adds the state of yearsOnThesis -overrides getStress() to provide a Grad specific version*/public class Grad extends Student {    private int yearsOnThesis;		/*	 Ctor takes an initial units and initial years on thesis.	*/	public Grad(int units, int thesis) {		// we use "super" to invoke the superclass ctor		// to init that part of ourselves		super(units);				// init our own ivars		yearsOnThesis = thesis;	}			/*	 Default ctor builds a Grad with 10 units and 0 yot.	*/	public Grad() {	    this(10, 0);    // "this" on first line of a ctor calls 	                    // a different ctor in the same class	}			/*     getStress() override	 Grad stress is 2 * Student stress + yearsOnThesis.	*/	@Override	public int getStress() {		// Use super.getStress() to invoke the Student		// version of getStress() instead of copy/pasting that		// code down here. The whole point of inheritance		// is not duplicating code.		int stress = super.getStress();				return(stress*2 + yearsOnThesis);	}		// Standard accessors	public void setYearsOnThesis(int yearsOnThesis) {		this.yearsOnThesis = yearsOnThesis;	}		public int getYearsOnThesis() {		return(yearsOnThesis);	}		// standard Hashcode auto-generated by Eclipse using the "source" menu	@Override	public int hashCode() {		final int prime = 31;		int result = super.hashCode();		result = prime * result + yearsOnThesis;		return result;	}	// standard Equals auto-generated by Eclipse using the "source" menu	@Override	public boolean equals(Object obj) {		if (this == obj)			return true;		if (!super.equals(obj))			return false;		if (getClass() != obj.getClass())			return false;		Grad other = (Grad) obj;		if (yearsOnThesis != other.yearsOnThesis)			return false;		return true;	}			/*	 Example client code of Student and Grad, demonstrating	 inheritance concepts.	*/	public static void main(String[] args) {		Student s = new Student(13);		Grad g = new Grad(13, 2);		Student x = null;		System.out.println("s " + s.getStress());		System.out.println("g " + g.getStress());		// Note how g responds to everything s responds to		// with a combination of inheritance and overriding...		s.dropUnits(3);		g.dropUnits(3);		System.out.println("s " + s.getStress());		System.out.println("g " + g.getStress());		/*		 OUTPUT...            s 130            g 262            s 100            g 202        */		// s.getYearsOnThesis();	// NO does not compile		g.getYearsOnThesis();	// ok		// Substitution rule -- subclass may play the role of superclass		x = g;	// ok		// At runtime, this goes to Grad.getStress()		// Point: message/method resolution uses the RT class of the receiver,		// not the CT class in the source code.		// This is essentially the objects-know-their-class rule at work.		x.getStress();      // returns 202		// g = x;	// NO -- does not compile,		// substitution does not work that direction		// x.getYearsOnThesis();	// NO, does not compile				// Buggy code 		if (s instanceof Grad){			((Grad)s).getYearsOnThesis();		}		if (x instanceof Grad){			System.out.println(((Grad)x).getYearsOnThesis());	// insert downcast			// Ok, so long as x really does point to a Grad at runtime		}			}		@Override	public String toString() {		return "Grad(units=" + units + "; years=" + yearsOnThesis + ")";	}}/* Things to notice...  -The ctor takes both Student and Grad state -- the Student state is passed up to the Student ctor by the first "super" line in the Grad ctor.  -getStress() is a classic override. Note that it does not _repeat_ the code  from Student.getStress(). It calls it using super, and fixes the result.  The whole point of inheritance is to avoid code repetition.   -Grad responds to every message that a Student responds to -- either  a) inherited such as getUnits() b) overridden such as getStress()  -Grad also responds to things that Students do not, such as getYearsOnThesis().*/