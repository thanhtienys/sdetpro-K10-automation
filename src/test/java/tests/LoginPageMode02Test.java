package tests;

import drivers.DriverFactory;
import models.pages.LoginPageMod01;
import models.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginPageMode02Test implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the target page
            driver.get(BASE_URL.concat(LOGIN_SLUG));

            //Input login credential
            LoginPageMod02 loginPageMod02 = new LoginPageMod02(driver);
            loginPageMod02.inputUsernameElem("teooo");
            loginPageMod02.inputPasswordElem("1231231");
            loginPageMod02.ClickLoginBtnElem();

            //DEBUG purpose only
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
