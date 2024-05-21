package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends PageBase{

    public MyAccount(WebDriver driver) {

        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordBtn;


    @FindBy(id="OldPassword")
     WebElement oldPasswordTxt;

    @FindBy(id="NewPassword")
     WebElement newPasswordTxt;

    @FindBy(id="ConfirmNewPassword")
     WebElement confirmNewPassword;

    @FindBy(xpath="//div[@class='buttons']/button")
    WebElement changePasswordLink;

   @FindBy(css=".bar-notification p")
  public WebElement changePasswordResult;

    public void openChangePassword(){

        clickButton(changePasswordBtn);
    }

    public void changePassword(String oldPassword, String newPassword){
        System.out.println("Old Password: " + oldPassword);
        System.out.println("New Password: " + newPassword);
        setTextElementText(oldPasswordTxt, oldPassword);
        setTextElementText(newPasswordTxt, newPassword);
        setTextElementText(confirmNewPassword, newPassword); // Confirming with oldPassword or adjust as per your application logic
        clickButton(changePasswordLink);
    }





}


