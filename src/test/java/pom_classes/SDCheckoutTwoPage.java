package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SDCheckoutTwoPage {
    WebDriver driver;
    public SDCheckoutTwoPage(WebDriver driver){
        this.driver=driver;
    }
    protected By headerPage= By.cssSelector(".subheader");
    protected By finishBtn=By.cssSelector(".btn_action.cart_button");

    public void checkPage(String header){
        Assert.assertEquals(driver.findElement(headerPage).getText(),header);
    }
    public void finishPurchase(){
        driver.findElement(finishBtn).click();
    }


}
