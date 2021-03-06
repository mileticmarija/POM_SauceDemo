package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SDHomePage {
    WebDriver driver;
    public SDHomePage(WebDriver driver){
        this.driver=driver;
    }

    protected By confirm= By.cssSelector("#inventory_filter_container .product_label");
    protected By backpackButton= By.cssSelector(".inventory_item:nth-child(1) .btn_primary.btn_inventory");
    protected By backpackSelect=By.cssSelector(".btn_secondary.btn_inventory");
    protected By shopingcart=By.cssSelector("#shopping_cart_container");
    protected By naziv = By.cssSelector("div.inventory_item:nth-child(1)>div>a>.inventory_item_name");
    protected By cena = By.cssSelector("div.inventory_item:nth-child(1)>div.pricebar>div");

    public void checkLogin(String message){
        Assert.assertEquals(driver.findElement(confirm).getText(),message);
    }
    public void selectBackpack(){
        driver.findElement(backpackButton).click();
        Assert.assertEquals(driver.findElement(backpackSelect).getText(),"REMOVE");
    }
    public void enterShopingCart(){
        driver.findElement(shopingcart).click();
    }
    public String getNaziv(){
        return driver.findElement(naziv).getText();
    }
    public String getCena(){
        return driver.findElement(cena).getText();
    }

}
