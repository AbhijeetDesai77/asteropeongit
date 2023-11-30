package PomClassesPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPomClass {

    @FindBy(xpath = "//input[@id=\"email\"]")
    private WebElement username;

    @FindBy(xpath = "//input[@id=\"pass\"]")
    private WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    public FacebookLoginPomClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String usernameValue) {
        username.sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        password.sendKeys(passwordValue);
    }

    public void clickLoginButton() {
        submitButton.click();
    }
}
