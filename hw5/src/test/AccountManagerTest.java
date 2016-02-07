package test;

import static org.junit.Assert.*;
import model.AccountManager;

import org.junit.Test;

public class AccountManagerTest {
	
	private AccountManager am = new AccountManager();

	@Test
	public void testCreateNewAccount() {
		am.createNewAccount("John", "123");
		assertTrue(am.hasAccount("John"));
		assertFalse(am.hasAccount("Jack"));
		assertTrue(am.isCorrectPassword("John", "123"));
		assertFalse(am.isCorrectPassword("John", "1234"));
		
	}

	@Test
	public void testHasAccount() {
		assertTrue(am.hasAccount("Patrick"));
		assertTrue(am.hasAccount("Molly"));
		assertFalse(am.hasAccount("Smith"));
		assertFalse(am.hasAccount("FloPup"));
	}

	@Test
	public void testIsCorrectPassword() {
		assertTrue(am.isCorrectPassword("Patrick", "1234"));
		assertTrue(am.isCorrectPassword("Molly", "FloPup"));
		assertFalse(am.isCorrectPassword("Smith", "43e"));
		assertFalse(am.isCorrectPassword("Patrick", ""));
		assertFalse(am.isCorrectPassword("FloPup", "Molly"));
		
	}

}