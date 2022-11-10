package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class Iframe {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the iframe page
            driver.get(Urls.BASE_URL.concat(Urls.IFRAME_SLUG));

            //Locate the iframe
            WebElement iframeElem = driver.findElement(By.cssSelector("iframe[id^='mce']"));

            //Switch to the iframe
            driver.switchTo().frame(iframeElem);

            //Input text input the text area
            WebElement editInputElem = driver.findElement(By.cssSelector("#tinymce"));
            editInputElem.click();
            editInputElem.clear();
            editInputElem.sendKeys("This is new value...........\n And this is the new line");

            //Switch the parent frame
            driver.switchTo().defaultContent();

            System.out.println(driver.findElement(By.partialLinkText("Selenium")).getAttribute("href"));

            //DEBUG purpose only
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
