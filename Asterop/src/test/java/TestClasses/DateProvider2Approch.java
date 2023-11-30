package TestClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PomClassesPack.FacebookLoginPomClass;

import org.openqa.selenium.WebDriver;

public class DateProvider2Approch {
	WebDriver driver;
	FacebookLoginPomClass FloginPom=new FacebookLoginPomClass(driver);
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse-workspace\\Asterop\\src\\main\\resources\\Driver\\chromedriver.exe" );
		ChromeOptions options =new ChromeOptions();
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		driver =new ChromeDriver();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@BeforeMethod
	public void getUrl() {
		driver.get("https://www.facebook.com/login/");
	}
	
	@AfterMethod
	public void refresh() {
		driver.navigate().refresh();
	}
	
	@DataProvider(name="dataforLogin")
	public Object[][] writedata() {
		Object[][] data=new Object[2][2];
		
		data[0][0]="abc";
		data[0][1]="123";
		
		data[1][0]="xyx";
		data[1][1]="456";
		return data;
	}
	
	@Test(dataProvider="dataforLogin")
	public void tc1(String Username,String Password) throws InterruptedException {
		FloginPom.uName();
		Thread.sleep(2000);
		FloginPom.pAssword();
		Thread.sleep(2000);
		FloginPom.submit();
		Thread.sleep(2000);
	}
	

}
