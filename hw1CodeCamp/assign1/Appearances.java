package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		// Create a map of each element and its appearances in both collections
		Map<T, Integer> aMap = calculateAppearances(a);
		Map<T, Integer> bMap = calculateAppearances(b);
		
		int result = 0;
		
		for(T key : aMap.keySet()){
			if (bMap.containsKey(key)
                    && aMap.get(key).equals(bMap.get(key)))
                result++;
		
		}
		return result; 			
			
	}
	
	/**
	 * Create the Map<T, Integer> of each element T and calculate its appearances (Integer) in the collection a
	 * @param a the collection
	 * @return the HashMap<T, Integer> of element T and its appearances in the collection a
	 */
	private static <T> Map<T, Integer> calculateAppearances(Collection<T> a){
		Map<T, Integer> aMap = new HashMap<T, Integer>();
		for(T elem : a){
			if(aMap.containsKey(elem)){
				aMap.put(elem, (aMap.get(elem) + 1));
			} else{
				aMap.put(elem, 1);
			}
		}
		return aMap;
		
	}
}
