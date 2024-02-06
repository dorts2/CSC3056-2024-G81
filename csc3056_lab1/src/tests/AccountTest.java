package tests;

import java.util.Date;
import model.Account;


public class AccountTest {
	
	public static void testConstructor() {
		
		String test_account_number = "1234";
		String test_username_of_account_holder = "John";
		String test_account_type = "Checking";
		Date test_account_opening_date = new Date();
		
		Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type, test_account_opening_date);
				
		
		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_opening_date() == test_account_opening_date; 
 		
		System.out.println("All Constructor tests passed");  
		
	}
	
	public static void testSetters() {
		 String new_account_number = "5678";
	        String new_username_of_account_holder = "Jane";
	        String new_account_type = "Savings";
	        Date new_account_opening_date = new Date();
	        
	        Account testAccount = new Account("1234", "John", "Checking", new Date());
	        
	        testAccount.setAccount_number(new_account_number);
	        testAccount.setUsername_of_account_holder(new_username_of_account_holder);
	        testAccount.setAccount_type(new_account_type);
	        testAccount.setAccount_opening_date(new_account_opening_date);
	        
	        assert testAccount.getAccount_number().equals(new_account_number);
	        assert testAccount.getUsername_of_account_holder().equals(new_username_of_account_holder);
	        assert testAccount.getAccount_type().equals(new_account_type);
	        assert testAccount.getAccount_opening_date().equals(new_account_opening_date); 
	        
	        System.out.println("All Setter tests passed");
	  
	}
	
	public static void main(String[] args) {
		testConstructor();
		testSetters();

	}
}
