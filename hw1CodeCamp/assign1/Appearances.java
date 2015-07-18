package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		Map<T, Integer> aMap = new HashMap<T, Integer>();
		Map<T, Integer> bMap = new HashMap<T, Integer>();
		
		// Create a map of each element and its appearances in a
		calculateAppearances(a, aMap);
		calculateAppearances(b, bMap);
		
		int result = 0;
		
		for(T key : aMap.keySet()){
			if (bMap.containsKey(key)
                    && aMap.get(key).equals(bMap.get(key)))
                result++;
		
		}
		return result; 			
			
	}
	
	/**
	 * Calculate and fill the Map<T, Integer> of each element T and its appearances (Integer) in the collection a
	 * @param a the collection
	 * @param aMap the map
	 */
	private static <T> void calculateAppearances(Collection<T> a, Map<T, Integer> aMap){
		for(T elem : a){
			if(aMap.containsKey(elem)){
				aMap.put(elem, (aMap.get(elem) + 1));
			} else{
				aMap.put(elem, 1);
			}
		}
		
	}
}
