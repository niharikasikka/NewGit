package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;


public class ValidateNavigationBarTest extends Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void executeBeforeEveryTest() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.navigate().to(prop.getProperty("url"));
		log.info("Successfully navigated to url");
	}
	
	@Test
	public void validateNavigation() throws IOException {

		HomePage homePageObject = new HomePage(driver);
		Assert.assertTrue(homePageObject.getNavigationBar().isDisplayed());
		log.info("Successfully validated the navigation");
	}

	@AfterTest
	public void executeAfterEveryTest() {
		driver.close();
		driver.quit();
		driver=null;
		log.info("Driver is closed");
	}
}
