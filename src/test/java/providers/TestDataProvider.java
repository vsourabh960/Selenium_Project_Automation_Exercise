package providers;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import utils.DataUtil;

/**
 * Centralized data provider for all test data
 * Uses @DataProvider to supply parameterized test data to test methods
 */
public class TestDataProvider {
	
	/**
	 * Provides login test data from login_testdata.csv
	 * CSV columns: email, password, isValidLogin, expectedMessage
	 */
	@DataProvider(name = "loginTestData")
	public Object[][] getLoginTestData() {
		List<Map<String, String>> testData = DataUtil.readTestDataFromCSV("login_testdata.csv");
		Object[][] result = new Object[testData.size()][1];
		
		for (int i = 0; i < testData.size(); i++) {
			result[i][0] = testData.get(i);
		}
		
		return result;
	}
	
	/**
	 * Provides registration test data from registration_testdata.csv
	 * CSV columns: email, name, firstName, lastName, company, address, 
	 *              country, state, city, zipcode, mobileNumber, day, month, year, password
	 */
	@DataProvider(name = "registrationTestData")
	public Object[][] getRegistrationTestData() {
		List<Map<String, String>> testData = DataUtil.readTestDataFromCSV("registration_testdata.csv");
		Object[][] result = new Object[testData.size()][1];
		
		for (int i = 0; i < testData.size(); i++) {
			result[i][0] = testData.get(i);
		}
		
		return result;
	}
	
	/**
	 * Provides logout test data from logout_testdata.csv
	 * CSV columns: email, password
	 */
	@DataProvider(name = "logoutTestData")
	public Object[][] getLogoutTestData() {
		List<Map<String, String>> testData = DataUtil.readTestDataFromCSV("logout_testdata.csv");
		Object[][] result = new Object[testData.size()][1];
		
		for (int i = 0; i < testData.size(); i++) {
			result[i][0] = testData.get(i);
		}
		
		return result;
	}
}
