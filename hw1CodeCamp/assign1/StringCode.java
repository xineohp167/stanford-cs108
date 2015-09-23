package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adjacent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		//abbcccddbbbxxx
		int maxRun = 0;
		int i = 0;
		while ( i < str.length()) {
			Character ch = str.charAt(i);
			int cur = i + 1;
			while(cur < str.length() && ch == str.charAt(cur)){
				cur++;
			}
			maxRun = maxRun > (cur-i) ? maxRun : (cur - i);
			i = cur;
		}
		return maxRun;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		if (str.length() < 1 ) return str;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(Character.isDigit(ch)){
				int num = Character.getNumericValue(ch);
				while(num > 0 && i < str.length()-1){
					sb.append(str.charAt(i+1));
					num--;
				}
			}else{
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		
		if(len <= 0) return false;
		if(len > a.length() || len > b.length()) return false;
		
		Set<String> aSubStringSet = new HashSet<String>();
		for(int iA = 0; (iA + len) < a.length(); iA++ ){
			String aSubString = a.substring(iA, iA + len);
			aSubStringSet.add(aSubString);
		}
		
		for(int iB = 0; (iB + len) < b.length(); iB++ ){
			String bSubString = b.substring(iB, iB + len);
			if(aSubStringSet.contains(bSubString)) return true;
		}
		
		return false;
	}
	
	
}
