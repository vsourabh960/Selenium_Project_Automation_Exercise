package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		try {
			Properties prop = new Properties();
			// Fixed: Use cross-platform Path API instead of hardcoded backslash
			Path configPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "config.properties");
			FileInputStream fis = new FileInputStream(configPath.toFile());
			prop.load(fis);
			fis.close();
			
			String url = prop.getProperty("url");
			String browser = prop.getProperty("browser");
			
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else {
				throw new IllegalArgumentException("Browser not supported: " + browser);
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties: " + e.getMessage(), e);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
