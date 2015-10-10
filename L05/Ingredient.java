// Ingredient.java
import java.util.*;

/**
 * The Ingredient class encapsulates the name of the ingredient
 * and its quantity in grams. Used to demonstrate standard overrides:
 * toString(), equals(), hashCode(), and compareTo().
 * Also demonstrates sorting and Javadoc.
 */

public class Ingredient implements Comparable<Ingredient> {
	private String name;
	private int grams;
	
	/**
	 * Constructs a new Ingredient.
	 * 
	 * @param name name of ingredient
	 * @param grams quantity of ingredient in grams
	 */
	public Ingredient(String name, int grams) {
		this.name = name;
		this.grams = grams;
	}
	
	/**
	 * Gets the name of the Ingredient.
	 * 
	 * @return name of ingredient
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the grams of the Ingredient.
	 * 
	 * @return grams value
	 */
	public int getGrams() {
		return grams;
	}
	
	/**
	 * Sets the grams of the Ingredient.
	 * 
	 * @param grams new grams value
	 */
	public void setGrams(int grams) {
		this.grams = grams;
	}
	
	
	/**
	 * Returns a String form of the Ingredient.
	 * Uses the format <code>"<i>name</i> (<i>grams-value</i> grams)"</code>
	 * 
	 * @return string form of ingredient
	 */
	@Override
	public String toString() {
		return name + " (" + grams + " grams)";
	}
	
	
	/**
	 * Compares this ingredient to the given object (standard override).
	 * 
	 * @return true if ingredient has the same value as the given object
	 */
	@Override
	public boolean equals(Object obj) {
		// Note: our argument must be Object, not Ingredient,
		// to match the equals() prototype up in the Object class.
		
		// Standard equals() tests...
		if (this == obj) return true;
		if (!(obj instanceof Ingredient)) return false;
		
		// Now do deep compare
		Ingredient other = (Ingredient)obj;
		return (grams==other.getGrams() && name.equals(other.getName()));
	}
	
	/**
	 * Returns an int hashcode for this ingredient (standard override).
	 * 
	 * @return int hashcode of ingredient
	 */
	@Override
	public int hashCode() {
		// if two objects are deeply the same, their
		// hash codes must be the same
		return (grams + name.length()*11);
		// could use name.hashCode() instead of name.length()
	}
	
	/**
	 * Compares the ingredient to the given object for sort order.
	 *  (This is the standard sorting override, implemented here
	 * since we implement the "Comparable" interface.)<br>
	 * Orders increasing by name, and for the same name, increasing by grams.
	 * This is the Java 5 version, generic for Comparable<Ingredient>, so
	 * the arg is type Ingredient.
	 * 
	 * @return negative/0/positive to indicate ordering vs. given object
	 */
	public int compareTo(Ingredient other) {
		int strCompare = name.compareTo(other.getName());
		if (strCompare != 0) return strCompare;
		else {
			if (grams < other.getGrams()) return -1;
			else if (grams > other.getGrams()) return 1;
			else return 0;
			// trick: could just return (grams - other.getGrams())
			// could access .grams directly ("sibling" access)
		}
	}
	
	
	public static void main(String args[]) {
		Ingredient a = new Ingredient("Apple", 112);
		Ingredient b = new Ingredient("Banana", 236);
		Ingredient b2 = new Ingredient("Banana", 236); // deeply the same as b
		
		System.out.println(a);	// calls toString()
		System.out.println(b);
		System.out.println("Apple eq Banana:" + (a.equals(b)));  // false
		System.out.println("Banana eq Banana2:" + (b.equals(b2)));  // true
		
		System.out.println("Apple hash:" + a.hashCode()); // 167
		System.out.println("Banana hash:" + b.hashCode()); // 313
		System.out.println("Banana2 hash:" + b2.hashCode()); // 313 (!)

		collectionDemo();
	}
	

	// Comparator class, new Java 5 form.
	// Comparator int compare(T, T) takes two arguments
	// Returns neg/0/pos if first arg is less/eq/greater
	// than second arg.
	private static class SortByGrams implements Comparator<Ingredient> {
		public int compare(Ingredient a, Ingredient b) {
			// trick: form the neg/0/pos by subtraction
			return (a.getGrams() - b.getGrams());
		}
	}

	
	public static void collectionDemo() {
		Ingredient a = new Ingredient("Apple", 112);
		Ingredient b = new Ingredient("Banana", 236);
		Ingredient b2 = new Ingredient("Banana", 100);
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(b2);
		ingredients.add(a);
		ingredients.add(b);
		
		System.out.println("ingredients:" + ingredients);
		// ingredients:[Banana (100 grams), Apple (112 grams), Banana (236 grams)]
		// note: uses the collection [ ... ] built-in toString()
		
		Collections.sort(ingredients);
		System.out.println("sorted:" + ingredients);
		// sorted:[Apple (112 grams), Banana (100 grams), Banana (236 grams)]
		
		Collections.sort(ingredients, new SortByGrams());
		System.out.println("sorted by grams:" + ingredients);
		// sorted by grams:[Banana (100 grams), Apple (112 grams), Banana (236 grams)]
		
		System.out.println("max:" + Collections.max(ingredients));
		// max:Banana (236 grams)
		// Also have built-in min(), max()
	}
}
		


