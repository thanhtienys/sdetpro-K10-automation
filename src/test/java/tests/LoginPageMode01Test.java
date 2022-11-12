package tests;

import drivers.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginPageMode01Test implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the target page
            driver.get(BASE_URL.concat(LOGIN_SLUG));

            //Input login credential
            LoginPageMod01 loginPageMod01 = new LoginPageMod01(driver);
            loginPageMod01.usernameElem().sendKeys("teo");
            loginPageMod01.passwordElem().sendKeys("12345678");
            loginPageMod01.loginBtnElem().click();

            //DEBUG purpose only
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
