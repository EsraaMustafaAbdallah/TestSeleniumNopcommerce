package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {


    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="gender-female")
    WebElement genderBtn;

    @FindBy(id="FirstName")
    WebElement firstNameBtn;

    @FindBy(id="LastName")
    WebElement lastNameBtn;

    @FindBy(id="Email")
    WebElement emailBtn;

    @FindBy(id="Password")
    WebElement passwordBtn;

    @FindBy(id="ConfirmPassword")
    WebElement confirmPasswordBtn;

    @FindBy(id="register-button")
    WebElement registerBtn;

    @FindBy(css=".result")
    public WebElement msgSuccess;


  @FindBy(linkText = "Log out")
  public WebElement logoutBtn;

  @FindBy(linkText = "My account")
  WebElement myAccountBtn;

    public void userRegistration(String firstname, String lastname, String email, String password, String confirmPassword){
        System.out.println("Password: " + password);
        System.out.println("Confirm Password: " + confirmPassword);
        clickButton(genderBtn);
        setTextElementText(firstNameBtn,firstname);
        setTextElementText(lastNameBtn,lastname);
        setTextElementText(emailBtn,email);
        setTextElementText(passwordBtn,password);
        setTextElementText(confirmPasswordBtn,confirmPassword);
        clickButton(registerBtn);
    }

    public void logout(){
         clickButton(logoutBtn);
    }
    public void openMyAccountPage()
    {
        clickButton(myAccountBtn);
    }

}
