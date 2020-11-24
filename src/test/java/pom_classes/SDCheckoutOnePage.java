package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SDCheckoutOnePage {
    WebDriver driver;
    public SDCheckoutOnePage(WebDriver driver){
        this.driver=driver;
    }

    protected By firstNameBox= By.cssSelector("#first-name");
    protected By lastNameBox=By.cssSelector("#last-name");
    protected By zipCodeBox=By.cssSelector("#postal-code");
    protected By continueBtn=By.cssSelector(".btn_primary.cart_button");
    protected By headerPage=By.cssSelector(".subheader");

    public void checkPageOne(String header){
        Assert.assertEquals(driver.findElement(headerPage).getText(),header);
    }

    public void enterFirstName(String firstName){
        driver.findElement(firstNameBox).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        driver.findElement(lastNameBox).sendKeys(lastName);
    }
    public void enterZipCode(String zipCode){
        driver.findElement(zipCodeBox).sendKeys(zipCode);
    }
    public void enterData(String firstName, String lastName, String zipCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
    }
    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }
    public void continuePurchase(String firstName, String lastName, String zipCode){
        enterData(firstName,lastName,zipCode);
        clickContinue();
    }
}
