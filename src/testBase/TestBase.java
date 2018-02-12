package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {

	private static WebDriver driver;
	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	private static String url;
	private static String browser;
	String browserName;
	private String email;
	private String pass;
	
	public TestBase() throws IOException{
		
			Properties prop = new Properties();
			FileReader fr;
			try {
					fr = new FileReader("src/resources/resources.properties");
					prop.load(fr);
				} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
				browser= prop.getProperty("browser");
				url= prop.getProperty("url");
				email = prop.getProperty("email");
				pass = prop.getProperty("pass");
			//init();
		}
		

		
	
	
		
		public static void init() throws IOException{
		//read properties file
		
			switch (browser.trim()) {
		
				case  "firefox":
					System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
					DesiredCapabilities capability = DesiredCapabilities.chrome();
					capability.setBrowserName("chrome");
					capability.setPlatform(Platform.WIN10);
					
					//driver = new ChromeDriver();
					//System.out.println("browser opened");
					driver =  new RemoteWebDriver(new URL("http://192.168.0.103:5566/wd/hub"),capability);
				break;
				default:
					//System.out.println(browser);
					break;
			}
			
	}
	
		
	
	
	@AfterMethod(alwaysRun=true)
	public void end(){
		driver.quit();
		System.out.println("browser closed");
		
	}
	public static void getURL(){
		driver.get(url);
		System.out.println("URL Opened");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public  WebDriver getDriver(){
		//stem.out.println(driver.getCurrentUrl());
		return driver;
	}
	
	
}
