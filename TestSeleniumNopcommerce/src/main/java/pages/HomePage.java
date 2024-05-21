package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    @FindBy(linkText ="Register")
    WebElement RegisterLink;

    @FindBy(linkText ="Log in")
    WebElement LoginLink;

    public void openRegistration(){

        clickButton(RegisterLink);
    }

    public void openLogin(){

        clickButton(LoginLink);
    }

}
