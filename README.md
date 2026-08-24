# Selenium Automation Exercise

A comprehensive Selenium-based test automation project for the [AutomationExercise](https://automationexercise.com/) e-commerce website using the **Page Object Model (POM)** design pattern.

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   ├── base/
│   │   │   ├── BaseTest.java        # Test setup/teardown, WebDriver initialization
│   │   │   └── BasePage.java        # Reusable Selenium actions (click, type, getText, etc.)
│   │   ├── pages/
│   │   │   ├── HomePage.java        # Home page object model
│   │   │   ├── LoginPage.java       # Login page object model
│   │   │   ├── RegisterPage.java    # Registration page object model
│   │   │   └── SignupPage.java      # Signup page object model
│   │   └── utils/
│   │       └── DataUtil.java        # CSV data reader utility
│   └── resources/
│       └── config.properties        # Configuration (URL, browser selection)
│
└── test/
    ├── java/
    │   ├── providers/
    │   │   └── TestDataProvider.java  # @DataProvider methods for parameterized tests
    │   └── tests/
    │       ├── LoginWithCorrectDetailsTest.java
    │       ├── LoginWithIncorrectDetailsTest.java
    │       ├── LogoutUserTest.java
    │       └── RegisterTest.java
    └── resources/
        ├── testng.xml               # TestNG test suite configuration
        └── testdata/
            ├── login_testdata.csv
            ├── registration_testdata.csv
            └── logout_testdata.csv
```

## 📦 Package Organization

### **base/** (Source Package)
- Contains framework-level classes used by all tests
- `BaseTest.java`: Sets up WebDriver before each test, loads config, quits after
- `BasePage.java`: Provides common Selenium operations with explicit waits

### **pages/** (Source Package)
- Contains Page Object Models (POM) for each web page
- Each class encapsulates page elements (locators) and interactions
- Extends `BasePage` to inherit common operations

### **utils/** (Source Package)
- `DataUtil.java`: Reads CSV files and returns data as List<Map<String, String>>
- Handles CSV parsing with proper header-value mapping

### **providers/** (Test Package)
- `TestDataProvider.java`: Contains `@DataProvider` methods
- Supplies parameterized test data from CSV files
- One `@DataProvider` per test scenario (login, registration, logout)

### **tests/** (Test Package)
- Contains test classes that use `@DataProvider` for parameterization
- No hardcoded test data—all data comes from CSV files
- Tests are data-driven and reusable

## 📊 Test Data Structure

### Login Test Data (`login_testdata.csv`)
```csv
email,password,isValidLogin,expectedMessage
rituchadar312@gmail.com,saurabh,true,Account Successfully Created!
invalidemail@gmail.com,wrongpassword,false,Your email or password is incorrect!
```

### Registration Test Data (`registration_testdata.csv`)
```csv
email,name,firstName,lastName,company,address,country,state,city,zipcode,mobileNumber,day,month,year,password
testuser1@gmail.com,John,John,Doe,Infosys,123 Main St,India,Maharashtra,Pune,400511,9876543210,1,January,2000,TestPass123
```

### Logout Test Data (`logout_testdata.csv`)
```csv
email,password
rituchadar312@gmail.com,saurabh
```

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- Chrome/Firefox/Edge browser with corresponding WebDriver

### Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Selenium_Project_Automation_Exercise
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Configure browser (optional)**
   - Edit `src/main/resources/config.properties`
   ```properties
   url=https://automationexercise.com/
   browser=chrome  # Options: chrome, firefox, edge
   ```

4. **Add test data**
   - CSV files are in `src/test/resources/testdata/`
   - Edit to add/modify test scenarios

### Running Tests

**Run all tests:**
```bash
mvn test
```

**Run specific test class:**
```bash
mvn test -Dtest=LoginWithCorrectDetailsTest
```

**Run with TestNG XML:**
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

**Run specific test suite:**
```bash
mvn test -Dgroups=smoke
```

## ✨ Key Features

### ✅ Page Object Model (POM)
- Separation of test logic from UI elements
- Easy maintenance and reusability
- Reduces duplication

### ✅ Parameterized Tests (@DataProvider)
- Tests run with multiple data sets from CSV
- Same test logic, different data
- Easy to add new test scenarios

### ✅ Externalized Test Data
- Test data in CSV files, not in code
- No hardcoded credentials or sensitive data in source
- Easy to update test scenarios

### ✅ Cross-Platform Compatibility
- Uses `Path` API instead of hardcoded backslashes
- Works on Windows, Linux, and Mac

### ✅ Explicit Waits
- Proper wait strategies for dynamic elements
- Prevents flaky tests
- Configurable timeout (default: 10 seconds)

### ✅ Proper Error Handling
- Config loading with meaningful error messages
- Exception handling in setup/teardown
- Safe element visibility checks

### ✅ Data-Driven Testing
- Login test: valid and invalid credentials
- Registration test: multiple user scenarios
- Logout test: different user accounts

## 🔧 Adding New Tests

### Step 1: Create CSV Test Data
Add new file in `src/test/resources/testdata/` (e.g., `search_testdata.csv`)

### Step 2: Add @DataProvider Method
Add method to `TestDataProvider.java`:
```java
@DataProvider(name = "searchTestData")
public Object[][] getSearchTestData() {
    List<Map<String, String>> testData = DataUtil.readTestDataFromCSV("search_testdata.csv");
    Object[][] result = new Object[testData.size()][1];
    
    for (int i = 0; i < testData.size(); i++) {
        result[i][0] = testData.get(i);
    }
    return result;
}
```

### Step 3: Create Page Object (if needed)
Create class in `pages/` package extending `BasePage`

### Step 4: Create Test Class
Create test in `tests/` package:
```java
@Test(dataProvider = "searchTestData", dataProviderClass = TestDataProvider.class)
public void searchProduct(Map<String, String> testData) {
    // Use testData.get("fieldName") to access values
}
```

## 📋 Bug Fixes Implemented

- ✅ **Fixed string comparison bug**: Changed `==` to `.equals()` in RegisterPage
- ✅ **Fixed hardcoded DOB parameters**: Now uses actual method parameters
- ✅ **Fixed Windows-specific file path**: Uses `Path` API for cross-platform compatibility
- ✅ **Added explicit waits**: Prevents element not found exceptions
- ✅ **Externalized test data**: All test data in CSV files
- ✅ **Implemented @DataProvider**: Parameterized tests for reusability
- ✅ **Proper package structure**: Organized classes by responsibility
- ✅ **Fixed logout assertion**: Now properly asserts logout result
- ✅ **Better error handling**: Meaningful error messages in exceptions
- ✅ **Removed hardcoded credentials**: Tests use external CSV data

## 📚 Technologies Used

- **Selenium WebDriver**: 4.47.0
- **TestNG**: 7.12.0
- **Java**: 17
- **Maven**: Build management
- **CSV**: Test data storage

## 🤝 Contributing

1. Create a new branch: `git checkout -b feature/new-feature`
2. Make changes and add tests
3. Ensure all tests pass: `mvn test`
4. Commit: `git commit -am 'Add new feature'`
5. Push: `git push origin feature/new-feature`
6. Submit a pull request

## 📝 License

This project is open source and available under the MIT License.

## 📧 Support

For questions or issues, please open an issue in the repository.
