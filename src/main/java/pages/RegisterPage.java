package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class RegisterPage extends BasePage{
	
	private By accountInfoText = By.xpath("//b[text()='Enter Account Information']");
	private By checkBoxM  = By.xpath("//label[contains(normalize-space(),'Mr.')]"); // //span[normalize-space(text())='Mr.']
	private By checkBoxF  = By.xpath("//label[contains(normalize-space(),'Mrs.')]");
	private By password = By.id("password");
	private By days = By.id("days");
	private By months = By.id("months");
	private By years = By.id("years");
	private By newsLatter = By.id("newsletter");
	private By specialOffer = By.id("optin");
	private By firstName = By.id("first_name");
	private By lastName = By.id("last_name");
	private By companyName = By.id("company");
	private By address1 = By.id("address1");
	private By country = By.id("country");
	private By state = By.id("state");
	private By city = By.id("city");
	private By zipcode = By.id("zipcode");
	private By mobile_number = By.id("mobile_number");
	private By createAccount = By.cssSelector("button[data-qa='create-account']");
	private By accountCreated = By.xpath("//b[text()='Account Created!']");
	private By continueAccountCreation = By.cssSelector("a[data-qa='continue-button']");
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isAccountInfoVisible() {
		return isDisplayed(accountInfoText);
	}
	
	public void clickMaleOrFemale(String gender) {
		if(gender == "Male") {
			click(checkBoxM);
		} else {
			click(checkBoxF);
		}
	}
	
	public void fillAccountDetails(String pass) {
		type(password, pass);
		click(newsLatter);
		click(specialOffer);
	}
	
	public void enterDOB(String day, String month, String year) {
		Select selectDay = new Select(selectDropdown(days));
		selectDay.selectByVisibleText("1");
		
		Select selectMonth = new Select(selectDropdown(months));
		selectMonth.selectByVisibleText("June");
		
		Select selectYear = new Select(selectDropdown(years));
		selectYear.selectByVisibleText("2000");
	}
	
	public void addressInformation(String fName, String lName, String company, String address,
			String countryName, String stateName, String cityName, String zipcodeValue, String mobNo) {
		type(firstName, fName);
		type(lastName, lName);
		type(companyName, company);
		type(address1, address);
		Select selectCountry = new Select(selectDropdown(country));
		selectCountry.selectByVisibleText(countryName);
		type(state, stateName);
		type(city, cityName);
		type(zipcode, zipcodeValue);
		type(mobile_number, mobNo);
	}
	
	public void createAccount() {
		click(createAccount);
	}
	
	public boolean isAccountCreatedVisible() {
		return isDisplayed(accountCreated);
	}
	
	public void countinueToHomePage() {
		click(continueAccountCreation);
	}
}
