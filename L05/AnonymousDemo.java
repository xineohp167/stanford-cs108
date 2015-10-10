import java.util.*;


public class AnonymousDemo {
	
	public static void main(String[] args) {
		Ingredient a = new Ingredient("Apple", 112);
		Ingredient b = new Ingredient("Banana", 236);
		Ingredient b2 = new Ingredient("Banana", 100);
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(b2);
		ingredients.add(a);
		ingredients.add(b);
		
		Collections.sort(ingredients, new Comparator<Ingredient>() {
			public int compare(Ingredient a, Ingredient b) {
				// trick: form the neg/0/pos by subtraction
				return (a.getGrams() - b.getGrams());
			}
		});
		System.out.println("sorted by grams (low to high):" + ingredients);

		Collections.sort(ingredients, new Comparator<Ingredient>() {
			public int compare(Ingredient a, Ingredient b) {
				// trick: form the neg/0/pos by subtraction
				return (b.getGrams() - a.getGrams());
			}
		});
		System.out.println("sorted by grams (high to low):" + ingredients);
		
		Collections.sort(ingredients, new Comparator<Ingredient>() {
			public int compare(Ingredient a, Ingredient b) {
				// trick: form the neg/0/pos by subtraction
				String aName = a.getName().substring(1);
				String bName = b.getName().substring(1);
				return aName.compareTo(bName);
			}
		});
		System.out.println("sorted by second letter:" + ingredients);
		
	}
}
