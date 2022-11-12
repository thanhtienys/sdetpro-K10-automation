package tests;

import drivers.DriverFactory;
import models.pages.LoginPageMod02;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginPageMode03Test implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the target page
            driver.get(BASE_URL.concat(LOGIN_SLUG));

            //Input login credential
            LoginPageMod03 loginPageMod03 = new LoginPageMod03(driver);
            loginPageMod03
                    .inputUsernameElem("teooo")
                    .inputPasswordElem("1231231")
                    .ClickLoginBtnElem();

            //DEBUG purpose only
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
