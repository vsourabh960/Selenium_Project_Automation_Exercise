package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginWithIncorrectDetailsTest extends BaseTest{
	
	@Test
	public void loginWithIncorrectDetails() {
		HomePage homepage = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		
		Assert.assertTrue(homepage.isHomePageDisplayed());
		homepage.clickSignupLogin();
		
		loginpage.enterEmailAndPassword("test123@gmail.com", "test123");
		loginpage.clickLogin();
		Assert.assertTrue(loginpage.isIncorrectLoginMsgShowing());
	}
}
