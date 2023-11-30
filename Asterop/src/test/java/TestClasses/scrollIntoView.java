package TestClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class scrollIntoView {
	
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Asterop\\src\\main\\resources\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://uitestingplayground.com/scrollbars");
        
       WebElement element = driver.findElement(By.xpath("//button[@id=\"hidingButton\"]"));
       
       JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("arguments[0].scrollIntoView(true)", element);
       Thread.sleep(2000);
       
       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
       
       WebDriverWait wait= WebDriverWait(driver,10);
       wait.until(ExpectedConditions.elementToBeClickable(element));
       
       driver.close();
        
		
	}

	private static WebDriverWait  WebDriverWait(WebDriver driver2, int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
