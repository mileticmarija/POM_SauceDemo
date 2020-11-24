package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SDCheckoutCompletePage {
    WebDriver driver;
    public SDCheckoutCompletePage(WebDriver driver){
        this.driver=driver;
    }

    protected By img= By.cssSelector(".pony_express");

    public void checkImg(){
        driver.findElement(img).isDisplayed();
    }
}
