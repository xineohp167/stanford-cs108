import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArraysExample {
	
	public static void main(String[] args) {
		/*
		 * // Test Arrays.asList
		List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
		System.out.println(stooges);
		Collections.sort(stooges);
		System.out.println(stooges);
		// can not do add and remove
		// instead can do set
		stooges.set(2, "Bob");
		System.out.println(stooges);
		// can do add and remove
		List<String> stooges2 = new ArrayList<String>(Arrays.asList("Larry", "Moe", "Curly"));
		stooges2.add("Bob");
		System.out.println(stooges2);
		// Test Arrays.copyOf
		String[] aS = {"Bob", "John", "Carl"};
		System.out.println(Arrays.toString(aS));
		aS[1] = "newJohn";
		System.out.println(Arrays.toString(aS));
		String[] aSCopy = Arrays.copyOf(aS, aS.length);
		System.out.println(Arrays.toString(aSCopy));
		aSCopy[1] = "oldJohn";
		System.out.println(Arrays.toString(aSCopy));
		System.out.println(Arrays.toString(aS));
		*/
		
		// Testing binarySearch
		int[] arrInt = {4, 2, 6, 7, 9, 25, 1};
		System.out.println(Arrays.toString(arrInt));
		int ind = Arrays.binarySearch(arrInt, 9);
		System.out.println(ind);
		System.out.println(Arrays.toString(arrInt));
		// Testing sort
		Arrays.sort(arrInt);
		System.out.println(Arrays.toString(arrInt));
		// Testing equals
		int[] arrInt1 = {1, 2, 3};
		int[] arrInt2 = {1, 2, 3};
		int[] arrInt3 = {3, 2, 1};
		System.out.println(Arrays.equals(arrInt1, arrInt2));
		System.out.println(Arrays.equals(arrInt1, arrInt3));
		// Testing fill
		Arrays.fill(arrInt1, 0);
		System.out.println(Arrays.toString(arrInt1));
		
	}
}
