package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;
import utility.PageHelper;

public class JsExecutor implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(FLOATING_MENU_SLUG));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            PageHelper pageHelper = new PageHelper(jsExecutor);

            //Scroll to bottom
//            jsExecutor.executeScript("window.scroll(0, document.body.scrollHeight)");
            pageHelper.scrollToBottom();

            //DEBUG purpose only
            Thread.sleep(2000);

            //Scroll to top
//            jsExecutor.executeScript("window.scroll(document.body.scrollHeight,0)");
            pageHelper.scrollToTop();

            //DEBUG purpose only
            Thread.sleep(2000);

            //Remove and change style element
            driver.get(BASE_URL.concat(DYNAMIC_CONTROLS_SLUG));
            WebElement checkboxFormElem = driver.findElement(By.id("checkbox-example"));
            WebElement inputFormElem = driver.findElement(By.id("input-example"));
            pageHelper.removeElem(inputFormElem);
            pageHelper.changeElemStyleToFocusMode(checkboxFormElem);

//            jsExecutor.executeScript("arguments[0].remove()", inputFormElem);
//            jsExecutor.executeScript("arguments[0].setAttribute('style','background:blue; broder: 4px solid red;')", checkboxFormElem);

            //DEBUG purpose only
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }

}
