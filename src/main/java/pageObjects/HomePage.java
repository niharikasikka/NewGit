package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	By loginButton = By.xpath("//span[contains(text(),'Login')]");
	By text = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigation = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	public WebElement getLogin() {
		
		return driver.findElement(loginButton);
	}
	
   public WebElement getNavigationBar() {
		
		return driver.findElement(navigation);
	}
	
	public String getText() {
		
		return driver.findElement(text).getText();
	}
}
