package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SDLoginPage {
    WebDriver driver;
    public SDLoginPage(WebDriver driver){
        this.driver=driver;
    }

    protected By userNameBox= By.cssSelector("#user-name");
    protected By passBox=By.cssSelector("#password");
    protected By loginButton=By.cssSelector("#login-button");
    protected By lockedMsg=By.cssSelector("h3");

    public void enterUserName(String username){
        driver.findElement(userNameBox).sendKeys(username);
    }
    public void enterPass(String pass){
        driver.findElement(passBox).sendKeys(pass);
    }
    public void enterData(String username, String pass){
        enterUserName(username);
        enterPass(pass);
    }
    public void submitData(){
        driver.findElement(loginButton).click();
    }
    public void login(String username,String pass){
        enterData(username,pass);
        submitData();
    }

    public void checkLockedMsg(String msg){
        Assert.assertEquals(driver.findElement(lockedMsg).getText(),msg);
    }
}
