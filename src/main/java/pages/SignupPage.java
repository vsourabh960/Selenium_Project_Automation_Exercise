package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class SignupPage extends BasePage{
	
	private By newUserText = By.xpath("//h2[text()='New User Signup!']");
	private By nameField = By.cssSelector("input[name='name']");
	private By emailField = By.cssSelector("input[data-qa='signup-email']");
	private By signupBtn = By.cssSelector("button[data-qa='signup-button']");
	
	public SignupPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isNewUserVisible() {
		return isDisplayed(newUserText);
	}
	
	public void enterNameAndEmail(String name, String email) {
		type(nameField, name);
		type(emailField, email);
	}
	
	public void clickSignup() {
		click(signupBtn);
	}
}
