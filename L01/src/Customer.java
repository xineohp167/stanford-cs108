
public class Customer {
	private String name;
	private String address;
	private int age;
	
	public Customer(String theName,int theAge) {
		name = theName;
		address = "";
		age = theAge;
	}
	
	public void updateAddress(String newAddress) {
		address = newAddress;
	}
	
	public void printInfo() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);		
	}
}
