package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnabled;
import url.Urls;

import java.time.Duration;

public class DynamicControls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(Urls.BASE_URL.concat(Urls.DYNAMIC_CONTROLS_SLUG));
            //Define 2 form locator
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");

            //Interact with the checkbox elem
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));
            //If the checkbox is not selected the select it
            if (!checkboxElem.isSelected()){
                checkboxElem.click();
            }
            //DEBUG purpose only
            Thread.sleep(1000);

            //Interact with the input form elem
            WebElement inputFormElem = driver.findElement(inputFormSel);
            WebElement inputFieldElem = inputFormElem.findElement(By.tagName("input"));
            WebElement enableBtnElem = inputFormElem.findElement(By.tagName("button"));

            //If the text field is not enable the click on the button
            if(!inputFieldElem.isEnabled()){
                enableBtnElem.click();
                //Wait until the text field is enable then send keys
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
                wait.until(new WaitForElementEnabled(By.cssSelector("#input-example input")));
            }
            inputFieldElem.sendKeys("This is new text!");

            //DEBUG purpose only
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
