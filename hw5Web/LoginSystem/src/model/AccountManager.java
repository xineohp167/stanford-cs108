package model;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
	public static final String ATTRIBUTE_NAME = "Account Manager";
	private Map<String, String> data;
	
	public AccountManager() {
		data = new HashMap<String, String>();
		createNewAccount("Patrick", "1234");
		createNewAccount("Molly", "FloPup");
		
	}

	/**
	 * Creates a new account with name and password
	 * @param name the name of the account
	 * @param password the password of the account
	 */
	public void createNewAccount(String name, String password) {
		data.put(name, password);
		
	}
	
	/**
	 * Returns if data has an account with this name.
	 * @param name the name of the account
	 * @return true if there is an account with that name
	 */
	public boolean hasAccount(String name){
		return data.containsKey(name);
	}
	
	/**
	 * Returns if there is such a account with that name and password
	 * @param name the name of the account
	 * @param password the password of the account
	 * @return true it there is such a account with that name and password
	 */
	public boolean isCorrectPassword(String name, String password){
		return data.containsKey(name) && data.get(name).equals(password);
	}

}
