import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GenericsExample {

	public static void main(String[] args) {

		/*// ** Create a List<String>
		List<String> a = new ArrayList<String>();
		a.add("Don't");
		a.add("blame");
		a.add("me");
		// ** foreach -- iterate over collection easily
		for (String str : a) {
			System.out.println(str);
		}
		// ** Instead of Iterator, make an Iterator<String>
		Iterator<String> it = a.iterator();
		while (it.hasNext()) {
			// NOTE: no cast required here -- it.next() is a String
			String string = it.next();
			System.out.println(string);
		}*/
		
		
		/*// ** Likewise, can make a List<Integer>
		List<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			ints.add(new Integer(i * i));
		}
		// No casts needed here -- it knows they are Integer
		//int sum = ints.get(0).intValue() + ints.get(1).intValue();
		
		// With auto Unboxing, can just write it like this...
		int sum = ints.get(0) + ints.get(1);
		System.out.println(sum);
		// Can go back and forth between typed Collections and untyped "raw"
		// forms -- may get a warning.
		List<String> genList = new ArrayList(); // warning
		List rawList = new ArrayList<String>(); // warning
		System.out.println(genList.getClass()); // class java.util.ArrayList
		System.out.println(rawList.getClass()); // class java.util.ArrayList
		rawList.add("hello"); // warning
		genList = rawList; // warning
		rawList = genList; // no warning
		 */	
		
		
		String s = convertInstanceOfObject("string", String.class);
	    System.out.println(s);
	    Integer i = convertInstanceOfObject(6, Integer.class);
	    System.out.println(i);
	    Integer j = convertInstanceOfObject(new Integer(15), Integer.class);
	    System.out.println(j);
	    String k = convertInstanceOfObject(345435.34, String.class);
	    System.out.println(k);
	    
	    // Output:
	    // string
	    // 6
	    // 15
	    // null
	    
	    System.out.println("Hi!");
	    System.out.println("There");
	
	}
	
	public static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
	    try {
	        return clazz.cast(o);
	    } catch(ClassCastException e) {
	        return null;
	    }
	}
	
	
	

}
