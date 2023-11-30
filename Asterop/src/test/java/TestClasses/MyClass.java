package TestClasses;
 
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyClass {
	
	WebDriver driver;
	    public static void main(String args[]) {
	        // Create an ArrayList
	        ArrayList<Object> list = new ArrayList<>();

	        // Add elements to the list
	        list.add("abhijeet");
	        list.add(4);
	        list.add(true);
	        list.add("true");

	        // Count the number of strings, integers, and booleans in the list
	        int stringCount = 0;
	        int intCount = 0;
	        int booleanCount = 0;

	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i) instanceof String) {
	                stringCount++;
	            } else if (list.get(i) instanceof Integer) {
	                intCount++;
	            } else if (list.get(i) instanceof Boolean) {
	                booleanCount++;
	            }
	        }

	        // Print the counts
	        System.out.println("Number of strings in the list: " + stringCount);
	        System.out.println("Number of integers in the list: " + intCount);
	        System.out.println("Number of booleans in the list: " + booleanCount);
	    }
	    
	    public void dragandDrop() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Asterop\\src\\main\\resources\\Driver\\chromedriver.exe");
	        ChromeOptions options = new ChromeOptions();
	        options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
	        WebDriver driver = new ChromeDriver();
	        
	        WebElement Sourceelement =driver.findElement(By.xpath(""));
	        WebElement dropelement = driver.findElement(By.xpath(""));
	        
	        Actions act =new Actions(driver);
	        
	        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	        
	        act.dragAndDrop(Sourceelement, dropelement).build().perform();
	    	
	    	
	    } 
	    
	    public void multiplewindowHandle() {
	    	
	    String mainwindow = driver.getWindowHandle();
	    Set<String> windows = driver.getWindowHandles();
	    
	    for(String window:windows) {
	    	if(!window.equals(mainwindow)) {
	    		driver.switchTo().window(window);
	    		
	    		driver.close();
	    		
	    		driver.switchTo().window(mainwindow);
	    	}
	    }
	    }
	    
	    public void alertclass() {
	    	Alert alt=driver.switchTo().alert();
	    	String alltextfromalert = alt.getText();
	    	if(alltextfromalert.contains("abcd") && alltextfromalert.contains("123")) {
	    		System.out.println("Username is correct");
	    		System.out.println("Password is correct");
	    	}
	    	else {
	    		System.out.println("Username isnot correct");
	    		System.out.println("Password isnot correct");
	    	}
	    	
	    }
	    
	    public void desiredcapabilites() {
	    	DesiredCapabilities capbility =new DesiredCapabilities();
	    	capbility.setCapability("Browsername", "Chrome");
	    	capbility.setCapability("Browser Version", 123);
	    	 
	    }
	}                