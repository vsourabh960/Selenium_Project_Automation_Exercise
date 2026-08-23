package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignupPage;

public class RegisterTest extends BaseTest {
	@Test
	public void register() {
		
		String name = "saurabh";
		
		HomePage home = new HomePage(driver);
		SignupPage signup = new SignupPage(driver);
		RegisterPage register = new RegisterPage(driver);
		
		home.clickSignupLogin();
		
		Assert.assertTrue(signup.isNewUserVisible(), "New User not visible, failed!");
		signup.enterNameAndEmail(name, "testchuchu1@gmail.com");
		signup.clickSignup();
		
		register.clickMaleOrFemale("Male");
		register.fillAccountDetails("saurabh");
		register.enterDOB("10", "March", "2003");
		register.addressInformation("Soruu", "Danny", "Infosys", "Phase 1", "India", "Maharashtra", "Pune", "400511", "7463526453");
		register.createAccount();
		Assert.assertTrue(register.isAccountCreatedVisible(), "Account Creation Failed!");
		register.countinueToHomePage();
		
		Assert.assertTrue(home.isUserNameVisible(), "User Name is not matching, Failed!");
		home.deleteAccount();
		Assert.assertTrue(home.isDeleteAccountTextVisible(), "Account is not deleted!");
		home.continueDelete();
	}
}
