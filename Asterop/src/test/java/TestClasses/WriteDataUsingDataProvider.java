package TestClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WriteDataUsingDataProvider {
	
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
	public void readData(String Username,String Password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Asterop\\src\\main\\resources\\Driver\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys(Password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		
	}

}
