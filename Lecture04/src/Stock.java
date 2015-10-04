// Stock.java

public class Stock implements Comparable<Stock>{
	
	private String name;
	private int grams;
	private int pricePerGram;
	private int totalPrice;
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getGrams() {
		return grams;
	}


	public void setGrams(int grams) {
		this.grams = grams;
	}


	public int getPricePerGram() {
		return pricePerGram;
	}


	public void setPricePerGram(int pricePerGram) {
		this.pricePerGram = pricePerGram;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
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

	
	

}
