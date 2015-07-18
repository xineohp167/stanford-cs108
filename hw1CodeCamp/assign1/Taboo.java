/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	
	private final Map<T, HashSet<T>> forbiddens;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		forbiddens = new HashMap<T, HashSet<T>>();
		
		T key = null;
		for(T value : rules){
			if(key != null && value != null){
				if(!forbiddens.containsKey(key)){
					forbiddens.put(key, new HashSet<T>());
				}
				forbiddens.get(key).add(value);
			}
			key = value;
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		 if(forbiddens.containsKey(elem)){
			 return forbiddens.get(elem);
		 }else{
			 return Collections.emptySet();
		 }
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		
		T current = null;
		Iterator<T> iter = list.iterator();
		while(iter.hasNext()){
			T next = iter.next();
			if(current != null && next != null 
					&& forbiddens.containsKey(current)
					&& forbiddens.get(current).contains(next)){
				iter.remove();
			}else{
				current = next;
			}
			
		}
	}
}
