package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	private static final int EXPLICIT_WAIT_TIMEOUT = 10;
	
	public BasePage(WebDriver driver) {
		this.driver = driver; 
	}
	
	// Fixed: Added explicit waits to prevent element not found exceptions
	public void click(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void type(By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}
	
	public String getText(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
	}
	
	public boolean isDisplayed(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public WebElement selectDropdown(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
