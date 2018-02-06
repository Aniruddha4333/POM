package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver = driver;
		System.out.println("inside Homepage constructor");
	}
	
	private static final String SingInLink = "//a[@class='login']";

	
	public void clickOnSignIn(){
		System.out.println("inside clickon SignIn");
		driver.findElement(By.xpath(SingInLink)).click();
	}
	
	public boolean isDisplayedHomePage(){
		WebDriverWait wt = new WebDriverWait(driver,30);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(SingInLink)));
		return driver.findElement(By.xpath(SingInLink)).isDisplayed();
	}
	
	
}
