// Customer example with explicit use of this

public class CustomerE {
	private String name;
	private String address;
	private int age;
	
	public CustomerE(String name,int age) {
		this.name = name;
		this.address = "";
		this.age = age;
	}
	
	public void updateAddress(String newAddress) {
		this.address = newAddress;
	}
	
	public void printInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Address: " + this.address);		
	}
}
