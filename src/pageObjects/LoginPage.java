package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	private static final String txtEmail = "email";
	
	private static final String txtpasswd = "passwd";
	
	private static final String BtnSignIn = "SubmitLogin";
	
	public void login(String email, String pass){
		driver.findElement(By.id(txtEmail)).sendKeys(email);
		driver.findElement(By.id(txtpasswd)).sendKeys(pass);
		driver.findElement(By.id(BtnSignIn)).click();
		
	}
	
	
	
}
