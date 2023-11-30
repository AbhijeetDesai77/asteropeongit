package PomClassesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pomclassForNewUser {
	
	@FindBy(xpath="")private WebElement EmployName;
	@FindBy(xpath="")private WebElement Designation;
	@FindBy(xpath="")private WebElement Sallary;
	@FindBy(xpath="")private WebElement SubmitButton;
	
	
	public pomclassForNewUser(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void empolyname(String Ename) {
		EmployName.sendKeys(Ename);
	}
	
	public void designation() {
		Designation.click();
		Select sel =new Select(Designation);
		sel.selectByValue(null);
	}
	WebDriver driver;
	public void sallary(String sallary) {
		//Sallary.sendKeys(sallary);
		
		WebElement element=driver.findElement(By.xpath(""));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=abcd", element);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	
	public void submitbutton() {
		SubmitButton.click();
	}

}





