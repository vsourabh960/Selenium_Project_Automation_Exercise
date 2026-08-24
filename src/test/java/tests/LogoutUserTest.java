package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import providers.TestDataProvider;

/**
 * Test class for validating user logout functionality
 * Uses parameterized test data from CSV file via @DataProvider
 */
public class LogoutUserTest extends BaseTest{
	
	/**
	 * Test logout functionality with test data from CSV file
	 * @param testData Map containing email and password from CSV
	 */
	@Test(dataProvider = "logoutTestData", dataProviderClass = TestDataProvider.class)
	public void logoutUser(Map<String, String> testData) {
		HomePage homepage = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		
		String email = testData.get("email");
		String password = testData.get("password");
		
		Assert.assertTrue(homepage.isHomePageDisplayed(), "Home page not displayed");
		homepage.clickSignupLogin();
		
		Assert.assertTrue(loginpage.isLoginTextVisible(), "Login text is not visible");
		loginpage.enterEmailAndPassword(email, password);
		loginpage.clickLogin();
		
		Assert.assertTrue(homepage.isUserNameVisible(), "User not logged in");
		homepage.logOut();
		
		// Fixed: Now properly asserts the result instead of ignoring it
		Assert.assertTrue(loginpage.isLoginTextVisible(), "User not logged out - login page should be visible");
	}
}
