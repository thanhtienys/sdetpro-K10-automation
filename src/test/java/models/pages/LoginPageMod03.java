package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMod03 {

    private final WebDriver driver;
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.id("password");
    private final static By loginBtnSel = By.cssSelector("button[type='submit']");

    public LoginPageMod03(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageMod03 inputUsernameElem(String username){
        driver.findElement(usernameSel).sendKeys(username);
        return this;
    }

    public LoginPageMod03 inputPasswordElem(String password){
        driver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    public void ClickLoginBtnElem(){
        driver.findElement(loginBtnSel).click();
    }


}
