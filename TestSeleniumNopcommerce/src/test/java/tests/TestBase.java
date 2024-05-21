package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browseName){
        if (browseName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browseName.equalsIgnoreCase("firefox"))
        {
            driver= new FirefoxDriver();
        }
        else if(browseName.equalsIgnoreCase("MicrosoftEdge"))
        {
            driver= new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

   @AfterSuite
    public void closeDriver() {
       driver.quit();
   }

}
