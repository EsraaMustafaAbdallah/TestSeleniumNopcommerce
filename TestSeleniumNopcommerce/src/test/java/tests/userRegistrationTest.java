package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;
import pages.UserRegistrationPage;

public class userRegistrationTest extends TestBase{
HomePage homeObject;
UserRegistrationPage registrationObject;
Login loginObject;

@Test(priority=1,alwaysRun=true)
    public void userCanRegister(){
    homeObject=new HomePage(driver);
    homeObject.openRegistration();
    registrationObject=new UserRegistrationPage(driver);

    registrationObject.userRegistration("esraa","mustafa","esoooo@gmail.com","123456","123456");
    Assert.assertTrue(registrationObject.msgSuccess.getText().contains("Your registration completed"));
     Assert.assertTrue(registrationObject.logoutBtn.getText().contains("Log out"));

}

@Test(dependsOnMethods = {"userCanRegister"})
    public void userCanLogout(){
    registrationObject.logout();
}

@Test(dependsOnMethods = {"userCanLogout"})
    public void userCanLogin(){
    homeObject.openLogin();
    loginObject=new Login(driver);
    loginObject.userLogin("esoooo@gmail.com","123456");
    Assert.assertTrue(registrationObject.logoutBtn.getText().contains("Log out"));

}

}
