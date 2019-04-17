package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void LoginFunctionality() {
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
	}

	public void enterEmail(String userName) {
		
		driver.findElement(By.xpath("//input[@name='user[email]']")).sendKeys(userName);
	}

	public void enterPassword(String password) {
		
		driver.findElement(By.xpath("//input[@name='user[password]']")).sendKeys(password);
	}
}
