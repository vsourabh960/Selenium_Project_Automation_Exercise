package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage{
	
	private By loginFormText = By.cssSelector("div[class='login-form'] h2");
	private By loginEmail = By.cssSelector("input[data-qa='login-email']");
	private By loginPassword = By.cssSelector("input[data-qa='login-password']");
	private By loginBtn = By.cssSelector("button[data-qa='login-button']");
	private By incorrectLoginMsg = By.cssSelector("div.login-form p");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isLoginTextVisible() {
		return isDisplayed(loginFormText);
	}
	
	public void enterEmailAndPassword(String email, String password) {
		type(loginEmail, email);
		type(loginPassword, password);
	}
	
	public void clickLogin() {
		click(loginBtn);
	}
	
	public boolean isIncorrectLoginMsgShowing() {
		return isDisplayed(incorrectLoginMsg);
	}
}
