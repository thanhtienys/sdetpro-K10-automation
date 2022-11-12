package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class BasicAuth {

    private static final String USERNAME = "admin";
    private static final String PW = "admin";
    private static String https = "https://";
    private static String link = "the-internet.herokuapp.com/basic_auth";
    private static String URL = https + USERNAME + ":" + PW + "@" + link;


    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(URL);

            //DEBUG purpose only
            Thread.sleep(5000);

        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
