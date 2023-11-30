package TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;


public class DataProviderWriteAndRead {
	
	WebDriver driver =new ChromeDriver();
	
	@DataProvider(name="logindata")
	public Object[][] writeData() {
		Object[][] data=new Object[2][2];
		
		data[1][0]="Admin";
		data[1][1]="123";
		
		data[2][0]="Admin1";
		data[2][1]="456";
		
		return data;
		
	}
	
	@Test(dataProvider="logindata")
	public void readData(String Username,String Password) {
		
		WebElement username=driver.findElement(By.xpath(""));
		username.sendKeys(Username);
		
		WebElement password=driver.findElement(By.xpath(""));
		password.sendKeys(Password);
	}

}
