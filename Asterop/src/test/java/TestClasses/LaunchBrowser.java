package TestClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import UtilityPackage.ScreenshotUtility;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class LaunchBrowser {

	ScreenshotUtility ss;

	WebDriver driver;

	@BeforeClass
	public void launchChromeBrowse() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dell\\eclipse-workspace\\Asterop\\src\\main\\resources\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);
		ss = new ScreenshotUtility();
		

	}

	@Test
	public void tc01() throws InterruptedException, IOException {
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);

		Thread.sleep(2000);

		ss.takescreenshot(driver);

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
