package test_classes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom_classes.*;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class SDBuyTest {
    WebDriver driver;
    String URL="https://www.saucedemo.com/";
    DriverManager driverManager;
    SDLoginPage sdlp;
    SDHomePage sdhp;
    SDCartPage sdcp;
    SDCheckoutOnePage sdcop;
    SDCheckoutTwoPage sdctp;
    SDCheckoutCompletePage sdccp;

    @BeforeMethod
    public void setUp(){
        driverManager= DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver=driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    @Parameters({"user","pass","checkLogin","checkPageOne","name","surname","zip","checkPageTwo"})
    public void e2e(String user,String pass,String checkLogin,String checkPageOne,String name,String surname,String zip,String checkPageTwo){
        sdlp=new SDLoginPage(driver);
        sdhp=new SDHomePage(driver);
        sdcp=new SDCartPage(driver);
        sdcop=new SDCheckoutOnePage(driver);
        sdctp=new SDCheckoutTwoPage(driver);
        sdccp=new SDCheckoutCompletePage(driver);

        sdlp.login(user,pass);
        sdhp.checkLogin(checkLogin);

        sdhp.selectBackpack();

        String naziv=sdhp.getNaziv();
        String cena=sdhp.getCena();

        sdhp.enterShopingCart();
        sdcp.checkCart();
        sdcp.checkCartItem(naziv,cena);

        sdcp.checkout();
        sdcop.checkPageOne(checkPageOne);
        sdcop.continuePurchase(name,surname,zip);
        sdctp.checkPage(checkPageTwo);
        sdctp.finishPurchase();
        sdccp.checkImg();

    }
    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}
