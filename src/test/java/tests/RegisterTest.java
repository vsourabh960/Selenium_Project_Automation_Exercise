package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignupPage;
import providers.TestDataProvider;

/**
 * Test class for user registration functionality
 * Uses parameterized test data from CSV file via @DataProvider
 */
public class RegisterTest extends BaseTest {
	
	/**
	 * Test user registration with data from external CSV file
	 * @param testData Map containing all required registration fields from CSV
	 */
	@Test(dataProvider = "registrationTestData", dataProviderClass = TestDataProvider.class)
	public void register(Map<String, String> testData) {
		
		HomePage home = new HomePage(driver);
		SignupPage signup = new SignupPage(driver);
		RegisterPage register = new RegisterPage(driver);
		
		// Extract test data from CSV map
		String email = testData.get("email");
		String name = testData.get("name");
		String firstName = testData.get("firstName");
		String lastName = testData.get("lastName");
		String company = testData.get("company");
		String address = testData.get("address");
		String country = testData.get("country");
		String state = testData.get("state");
		String city = testData.get("city");
		String zipcode = testData.get("zipcode");
		String mobileNumber = testData.get("mobileNumber");
		String day = testData.get("day");
		String month = testData.get("month");
		String year = testData.get("year");
		String password = testData.get("password");
		
		home.clickSignupLogin();
		
		Assert.assertTrue(signup.isNewUserVisible(), "New User signup section not visible");
		signup.enterNameAndEmail(name, email);
		signup.clickSignup();
		
		register.clickMaleOrFemale("Male");
		register.fillAccountDetails(password);
		register.enterDOB(day, month, year);
		register.addressInformation(firstName, lastName, company, address, country, state, city, zipcode, mobileNumber);
		register.createAccount();
		
		Assert.assertTrue(register.isAccountCreatedVisible(), "Account creation confirmation not shown");
		register.countinueToHomePage();
		
		Assert.assertTrue(home.isUserNameVisible(), "User name not visible after registration");
		home.deleteAccount();
		Assert.assertTrue(home.isDeleteAccountTextVisible(), "Account deletion confirmation not shown");
		home.continueDelete();
	}
}
