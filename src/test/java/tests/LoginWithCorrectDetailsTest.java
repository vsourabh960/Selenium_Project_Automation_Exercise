package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginWithCorrectDetailsTest extends BaseTest{
	
	@Test
	public void loginWithCorrectDetails() {
		HomePage homepage = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		
		Assert.assertTrue(homepage.isHomePageDisplayed());
		homepage.clickSignupLogin();
		
		Assert.assertTrue(loginpage.isLoginTextVisible(), "Login text is not visible, Failed!");
		loginpage.enterEmailAndPassword("rituchadar312@gmail.com", "saurabh");
		loginpage.clickLogin();
		
		Assert.assertTrue(homepage.isUserNameVisible());
		homepage.deleteAccount();
		Assert.assertTrue(homepage.isDeleteAccountTextVisible());
	}
}
