package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageBase{
    public Login(WebDriver driver) {

        super(driver);
    }

    @FindBy(id="Email")
    WebElement emailBtn;

    @FindBy(id="Password")
    WebElement passwordBtn;

    @FindBy(css=".returning-wrapper div button")
    WebElement loginBtn;

    public void userLogin(String email, String password){
        setTextElementText(emailBtn,email);
        setTextElementText(passwordBtn,password);
        clickButton(loginBtn);

    }
}


