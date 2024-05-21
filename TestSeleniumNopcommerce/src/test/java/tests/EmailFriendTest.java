package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;
import pages.Login;

public class EmailFriendTest extends TestBase
{
    HomePage homeObject ;
    UserRegistrationPage registerObject ;
    Login loginObject ;
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject ;
    ProductDetailsPage detailsObject ;
    EmailPage emailObject ;

    // 1- User Registration
    @Test(priority=1,alwaysRun=true)
    public void UserCanRegisterSuccssfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistration();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("esraa","mustafa","esoooo@gmail.com","123456","123456");
        Assert.assertTrue(registerObject.msgSuccess.getText().contains("Your registration completed"));
    }

    // 2- Search For Product
    @Test(priority=2)
    public void UserCanSearchWithAutoSuggest()
    {
        try {
            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("MacB");
            detailsObject = new ProductDetailsPage(driver);
            Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
        } catch (Exception e) {
            System.out.println("Error occurred  " + e.getMessage());
        }
    }

    // 3- Email to Friend
    @Test(priority=3)
    public void RegisteredUserCanSendProductToFriend()
    {
        detailsObject.openSendEmail();
        emailObject = new EmailPage(driver);
        emailObject.SendEmailToFriend("aaa@tte.com", "Hello my friend , check this product");
        Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
    }

    // 4- User Lgoout
    @Test(priority=4)
    public void RegisteredUserCanLogout()
    {
        registerObject.logout();
    }

}
