package test_classes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.SDHomePage;
import pom_classes.SDLoginPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class SDLoginTests {
    WebDriver driver;
    String URL="https://www.saucedemo.com/";
    DriverManager driverManager;
    SDLoginPage sdlp;
    SDHomePage sdhp;

    @BeforeMethod
    public void setUp(){
        driverManager= DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver=driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void loginStandard(){
        sdlp=new SDLoginPage(driver);
        sdhp=new SDHomePage(driver);

        sdlp.login("standard_user","secret_sauce");
        sdhp.checkLogin("Products");
    }

    @Test
    public void loginLockedOutUser(){
        sdlp=new SDLoginPage(driver);

        sdlp.login("locked_out_user","secret_sauce");
        sdlp.checkLockedMsg("Epic sadface: Sorry, this user has been locked out.");
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}
