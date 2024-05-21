package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;
import pages.MyAccount;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    Login loginObject; // Initialize the loginObject here
    MyAccount myAccountObject;
    String oldPassword="123456";
    String newPassword="1234567";
    String firstname="esraa";
    String lastname="mustafa";
    String email="esooooo@gmail.com" ;


    @Test(priority=1)
    public void userCanRegister(){
        homeObject=new HomePage(driver);
        homeObject.openRegistration();
        registrationObject=new UserRegistrationPage(driver);

        registrationObject.userRegistration(firstname,lastname,email,oldPassword,oldPassword);
        Assert.assertTrue(registrationObject.msgSuccess.getText().contains("Your registration completed"));


    }
    @Test(priority = 2)
    public void RegisteredUserCanChangePassword(){
        myAccountObject=new MyAccount(driver);
        registrationObject.openMyAccountPage();
        myAccountObject.openChangePassword();
        myAccountObject.changePassword(oldPassword,newPassword);
        Assert.assertTrue(myAccountObject.changePasswordResult.getText().contains("Password was changed"));
    }
    @Test(priority = 3)
    public void userCanLogout(){

        registrationObject.logout();
    }

    @Test(priority = 4)
    public void userCanLogin(){
        homeObject.openLogin();
        loginObject = new Login(driver); // Initialize the loginObject
        loginObject.userLogin(email, newPassword);
        Assert.assertTrue(registrationObject.logoutBtn.getText().contains("Log out"));
    }


    @Test(priority=5)
    public void UserLogout()
    {
        registrationObject.logout();
    }



}
