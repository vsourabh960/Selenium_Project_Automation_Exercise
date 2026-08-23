package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LogoutUserTest extends BaseTest{
	
	@Test
	public void logoutUser() {
		HomePage homepage = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		
		Assert.assertTrue(homepage.isHomePageDisplayed());
		homepage.clickSignupLogin();
		
		Assert.assertTrue(loginpage.isLoginTextVisible());
		loginpage.enterEmailAndPassword("testcase1233@gmail.com", "saurabh");
		loginpage.clickLogin();
		
		Assert.assertTrue(homepage.isUserNameVisible());
		homepage.logOut();
		
		loginpage.isLoginTextVisible();
	}
}
