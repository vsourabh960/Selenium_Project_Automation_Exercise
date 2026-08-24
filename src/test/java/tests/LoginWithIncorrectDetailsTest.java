package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import providers.TestDataProvider;

/**
 * Test class for validating login with incorrect credentials
 * Uses parameterized test data from CSV file via @DataProvider
 */
public class LoginWithIncorrectDetailsTest extends BaseTest{
	
	/**
	 * Test login with invalid credentials from external test data
	 * @param testData Map containing email, password, and validation flags from CSV
	 */
	@Test(dataProvider = "loginTestData", dataProviderClass = TestDataProvider.class)
	public void loginWithIncorrectDetails(Map<String, String> testData) {
		HomePage homepage = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		
		String email = testData.get("email");
		String password = testData.get("password");
		boolean isValidLogin = Boolean.parseBoolean(testData.get("isValidLogin"));
		
		// Only run this test for invalid login scenarios
		if (!isValidLogin) {
			Assert.assertTrue(homepage.isHomePageDisplayed(), "Home page not displayed");
			homepage.clickSignupLogin();
			
			Assert.assertTrue(loginpage.isLoginTextVisible(), "Login text is not visible");
			loginpage.enterEmailAndPassword(email, password);
			loginpage.clickLogin();
			
			Assert.assertTrue(loginpage.isIncorrectLoginMsgShowing(), "Error message should be displayed for invalid credentials");
		}
	}
}
