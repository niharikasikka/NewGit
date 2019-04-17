package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;


public class LoginTest extends Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void executeBeforeEveryTest() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		log.info("test log");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName, String password) throws IOException {
		
		driver.navigate().to(prop.getProperty("url"));
		log.info("Successfully navigated to url");
		HomePage homePageObject = new HomePage(driver);
		homePageObject.getLogin().click();

		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterEmail(userName);
		loginPageObject.enterPassword(password);
		loginPageObject.LoginFunctionality();
		log.info("User signed in successfully");
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];//size of the array is 2 rows and 2 columns
		//0th row
		data[0][0]="niharikasikka@gmail.com";
		data[0][1]="sikka111";
		//1th row
		data[1][0]="tonysinghlotay@gmail.com";
		data[1][1]="kaur123";
		
		return data;
	}
	
	@AfterTest
	public void executeAfterEveryTest() {
		driver.close();
		driver.quit();
		driver=null;
		log.info("Driver is closed");
	}
	

} 