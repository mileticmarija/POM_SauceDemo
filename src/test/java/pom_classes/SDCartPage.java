package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SDCartPage {
    WebDriver driver;
    public SDCartPage(WebDriver driver){
        this.driver=driver;
    }
    //SDHomePage sdhp;

    protected By yourCart=By.cssSelector(".subheader");
    protected By itemName=By.cssSelector(".inventory_item_name");
    protected By itemPrice=By.cssSelector(".inventory_item_price");
    protected By checkoutBtn=By.cssSelector(".btn_action.checkout_button");


    public void checkCart(){
        Assert.assertEquals(driver.findElement(yourCart).getText(),"Your Cart");
    }


    public void checkCartItem(String naziv, String cena){
        //sdhp=new SDHomePage(driver);
        String cenaKorpa=driver.findElement(itemPrice).getText();
        //if (driver.findElement(itemName).getText().equalsIgnoreCase(sdhp.naziv1) && driver.findElement(itemPrice).getText().equalsIgnoreCase(sdhp.cena1));
        Assert.assertEquals(driver.findElement(itemName).getText(),naziv);
        Assert.assertEquals(Double.valueOf(cena.substring(1,6)),Double.valueOf(cenaKorpa));
    }
    public void checkout(){
        driver.findElement(checkoutBtn).click();
    }
}
