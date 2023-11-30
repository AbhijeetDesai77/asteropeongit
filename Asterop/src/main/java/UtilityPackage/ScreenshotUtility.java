package UtilityPackage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;



public class ScreenshotUtility{
	WebDriver driver;
	public void takescreenshot(WebDriver driver) throws IOException {
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  
		  File f=new File("C:\\Users\\Dell\\Downloads\\Screenshot");
		  
		  FileHandler.copy(src, f);
	}
}
