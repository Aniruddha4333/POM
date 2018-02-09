package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestBase;



public class First extends TestBase {
	
	HomePage homepage;
	WebDriver driver;
	LoginPage loginPage;
	
	public First() throws IOException{
		super();
		//System.out.println("first");
		
	}
	
	@BeforeMethod
	public void statUp() throws IOException{
		init();
		this.driver = getDriver();
		homepage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void firstTest(){
		
		getURL();
		Assert.assertTrue(homepage.isDisplayedHomePage());
		System.out.println(homepage.isDisplayedHomePage());
		System.out.println("inside login test 1");
		homepage.clickOnSignIn();
		loginPage.login("patil.aniruddha8@gmail.com", "Ani4333#");
		//System.out.println(username+password);
		
	}
	
	@Test
	public void secondTest() throws IOException{
		getURL();
		Assert.assertTrue(homepage.isDisplayedHomePage());
		System.out.println(homepage.isDisplayedHomePage());
		System.out.println("inside login test 2");
		homepage.clickOnSignIn();
		loginPage.login("patil.aniruddha8@gmail.com", "Ani4333#");
		//System.out.println(username+password);
	}
	
}