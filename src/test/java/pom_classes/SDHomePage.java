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

// String naziv="Sauce Labs Backpack";
// String cena="$29.99";

//   String naziv1=driver.findElement(By.cssSelector(".inventory_item:nth-child(1)>div>a>div")).getText();
//   String cena1=driver.findElement(By.cssSelector(".inventory_item:nth-child(1) .inventory_item_price")).getText();

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

}
