
public class MultiDimensionalExample {

	static String[][] cartoons = {
			{"Homer", "Marge", "Bart", "Lisa", "Maggie"},
			{"Peter", "Lois", "Meg", "Chris", "Stewie", "Brian"},
			{"Cartman", "Kenny", "Stan", "Kyle"}};

	public static void main(String[] args) {
		
		for(int i=0; i < cartoons.length; i++) {
			for (int j=0; j < cartoons[i].length;j++) {
				System.out.println("Character: " + cartoons[i][j]);
			}
		}
		
	}

}
