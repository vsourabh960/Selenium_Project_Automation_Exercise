package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage{
	private By signupLoginBtn = By.cssSelector("a[href='/login']");
	private By deleteAccountBtn = By.cssSelector("a[href='/delete_account']");
	private By logoutBtn = By.cssSelector("a[href='/logout']");
	private By accountDeleteText = By.xpath("//b[text()='Account Deleted!']");
	private By continueDeleteBtn = By.cssSelector("a[data-qa='continue-button']");
	private By username = By.tagName("b");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isHomePageDisplayed() {
		return driver.getTitle().contains("Automation Exercise");
	}
	
	public void clickSignupLogin() {
		click(signupLoginBtn);
	}
	
	public void deleteAccount() {
		click(deleteAccountBtn);
	}
	
	public void logOut() {
		click(logoutBtn);
	}
	
	public boolean isUserNameVisible() {
		return isDisplayed(username);
	}
	
	public boolean isDeleteAccountTextVisible() {
		return isDisplayed(accountDeleteText);
	}
	
	public void continueDelete() {
		click(continueDeleteBtn);
	}
}
