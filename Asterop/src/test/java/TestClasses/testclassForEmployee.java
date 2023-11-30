package TestClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PomClassesPack.pomclassForNewUser;

public class testclassForEmployee {
	
	WebDriver driver;
	pomclassForNewUser pomclass =new pomclassForNewUser(driver);
	
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "chrodriver path");
		driver =new ChromeDriver();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	@BeforeMethod
	public void getUrl() {
		driver.get("");
	}
	
	@AfterMethod
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	@Test(priority=1)
	public void tc01() {
		pomclass.empolyname("abcd");
		pomclass.designation();
		pomclass.sallary("11111111");
		pomclass.submitbutton();
		
		Alert alt=driver.switchTo().alert();
		String alertText = alt.getText();
		
		Assert.assertTrue(alertText.contains("abcd"),"Name not found");
		Assert.assertTrue(alertText.contains("Manager"),"Designation not found");
		Assert.assertEquals(alertText.contains("1111111"), "Sallary is not prestent");

	}

}
