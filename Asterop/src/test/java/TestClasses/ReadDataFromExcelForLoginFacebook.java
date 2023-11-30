package TestClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import PomClassesPack.FacebookLoginPomClass;
import UtilityPackage.ReadDataFromExcel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadDataFromExcelForLoginFacebook {

    WebDriver driver;
    FacebookLoginPomClass FloginPom;

    @BeforeClass
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Asterop\\src\\main\\resources\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver();
        FloginPom = new FacebookLoginPomClass(driver);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @AfterMethod
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @BeforeMethod
    public void openLoginPage() {
        driver.get("https://www.facebook.com/login/");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {
        ReadDataFromExcel excelData = new ReadDataFromExcel();
        return excelData.readExcel();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws InterruptedException {
        FloginPom.enterUsername(username);
        Thread.sleep(2000);
        FloginPom.enterPassword(password);
        Thread.sleep(2000);
        FloginPom.clickLoginButton();
        Thread.sleep(2000);
        
        Alert alt=driver.switchTo().alert();
       String alrttext = alt.getText();
       if(alrttext.contains("abcd")&& alrttext.contains("123")) {
    	   System.out.println("username is same on popup");
    	   System.out.println("Password is same on popup");
       }
       else {
    	   System.out.println("username is not same on popup");
    	   System.out.println("Password is not same on popup");
       }
       
        

        // Add assertions or further steps as needed
       
       
    }
    @Test
    public void handleiframe() {
    	driver.switchTo().frame(0);
    	driver.switchTo().defaultContent();
    	
    }
    
    public void actionclass() throws IOException {
    	Actions act =new Actions(driver);
    	act.moveToElement(null).build().perform();
    	act.doubleClick().build().perform();
    	
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	WebElement element = driver.findElement(By.xpath(""));
      	js.executeScript("arguments[0].value=abcd", element);
      	
      	js.executeScript("arguments[0].scrollIntoView(true)",element);
    	
    	List<WebElement> links = driver.findElements(By.tagName("a"));
    	System.out.println(links.size());
    	for(WebElement link:links) {
    		link.getAttribute("herf");
    	}
    	 String url="";
    	 @SuppressWarnings("deprecation")
		URL obj = new URL(url);
         HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
    	 int actualrespose = connection.getResponseCode();
    	
    	if(actualrespose>=200 && actualrespose<300) {
    		System.out.println("links are not broken");
    	}
    	else {
    		System.out.println("links are broken");
    	}
    	testData.add(new Object[] {username,password});
    	
    	return testData.toArray(new Object [0][0]);
  
    	

    }
 
}
