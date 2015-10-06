import java.util.Comparator;

// Stock.java

public class Stock implements Comparable<Stock>{
	
	// Instance variables
	private String name;
	private int grams;
	private int pricePerGram;
	private int totalPrice;
	
	// Default values
	private static final int INITIAL_GRAMS = 0;
	private static final int INITIAL_PRICE_PER_GRAM = 0;

	
	// Constructors
	
	/**
	 * Constructs a new Stock.<br>
	 * The totalPice is grams * pricePerGram
	 * @param name the name of the Stock
	 * @param grams the weight in grams
	 * @param pricePerGram price for a gram
	 */
	public Stock(String name, int grams, int pricePerGram) {
		this.name = name;
		this.grams = grams;
		this.pricePerGram = pricePerGram;
		this.totalPrice = grams * pricePerGram;
	}
	
	/**
	 * Constructs a new Stock with name.<br>
	 * Initializes the object with default values for 
	 * grams (grams = 0) and pricePerGramf(0).
	 * @param name the name of the Stock
	 */
	public Stock(String name) {
		this(name, INITIAL_GRAMS, INITIAL_PRICE_PER_GRAM);	
	}


	/**
	 * Gets the name of the Stock
	 * @return name of the stock
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the name of the stock
	 * @param name the new name ot the stock
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Gets the name of the stock
	 * @return grams of the stock
	 */
	public int getGrams() {
		return grams;
	}


	/**
	 * Sets the weight in grams
	 * @param grams the new weight in grams
	 */
	public void setGrams(int grams) {
		this.grams = grams;
	}


	/**
	 * Gets the price per gram of the stock
	 * @return the price per gram
	 */
	public int getPricePerGram() {
		return pricePerGram;
	}


	/**
	 * Sets the new price per gram
	 * @param pricePerGram new price per gram
	 */
	public void setPricePerGram(int pricePerGram) {
		this.pricePerGram = pricePerGram;
	}

	/**
	 * Gets the total price of the stock.<br>
	 * The total price is computes as: grams*pricePerGram
	 * @return the total price of the stock
	 */
	public int getTotalPrice() {
		return totalPrice;
	}


	@Override
	public int compareTo(Stock other) {
		int strCompare = name.compareToIgnoreCase(other.getName());
		if(strCompare != 0 ) return strCompare;
		else{
			int priceCompare = this.pricePerGram - other.pricePerGram;
			if(priceCompare != 0) return priceCompare;
			else{
				return this.grams - other.grams;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Stock [name=" + name + ", grams=" + grams + ", pricePerGram="
				+ pricePerGram + ", totalPrice=" + totalPrice + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grams;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pricePerGram;
		result = prime * result + totalPrice;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Stock))
			return false;
		Stock other = (Stock) obj;
		if (grams != other.grams)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pricePerGram != other.pricePerGram)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}
	
	
	// Implementing different Comparators
	
	public static class StockSortByGrams implements Comparator<Stock> {
		public int compare(Stock a, Stock b) {
			// trick: form the neg/0/pos by subtraction
			return (a.getGrams() - b.getGrams());
		}
	}
	
	public static class StockSortByPricePerGram implements Comparator<Stock> {
		public int compare(Stock a, Stock b) {
			// trick: form the neg/0/pos by subtraction
			return (a.getPricePerGram() - b.getPricePerGram());
		}
	}
	
	public static class StockSortByTotalPrice implements Comparator<Stock> {
		public int compare(Stock a, Stock b) {
			// trick: form the neg/0/pos by subtraction
			return (a.getTotalPrice() - b.getTotalPrice());
		}
	}
	
	// Another option is to use public static field of Comparator
	public static Comparator<Stock> StockSortByName = new Comparator<Stock>(){

		@Override
		public int compare(Stock o1, Stock o2) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}
		
	};

}


