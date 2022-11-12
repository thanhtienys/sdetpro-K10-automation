package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JsAlerts {

    private static final By jsAlertSel = By.cssSelector("button[onclick=\"jsAlert()\"]");
    private static final By jsConfirmSel = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    private static final By jsPromptSel = By.cssSelector("button[onclick=\"jsPrompt()\"]");
    private static final By resultTextSel = By.cssSelector("#result");

    private static final boolean IS_ACCEPT = true , IS_DISMISS = false;

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(Urls.BASE_URL.concat(Urls.JAVASCRIPT_ALERTS_SLUG));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            //JsAlert | OK
            WebElement triggerAlertBtnElem = driver.findElement(jsAlertSel);
//            triggerAlertBtnElem.click();
//            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
//            jsAlert.accept();
            handleAlert(wait, triggerAlertBtnElem, IS_ACCEPT);
            System.out.println(driver.findElement(resultTextSel).getText());

            //JsConfirm | Cancel
            WebElement triggerConfirmBtnElem = driver.findElement(jsConfirmSel);
//            triggerConfirmBtnElem.click();
//            Alert jsConfirm = wait.until(ExpectedConditions.alertIsPresent());
//            jsConfirm.dismiss();
            handleAlert(wait, triggerConfirmBtnElem, IS_DISMISS);
            System.out.println(driver.findElement(resultTextSel).getText());

            //JsPrompt | Input text then accept
            WebElement triggerPromptBtnElem = driver.findElement(jsPromptSel);
//            triggerPromptBtnElem.click();
//            Alert jsPrompt = wait.until(ExpectedConditions.alertIsPresent());
//            jsPrompt.sendKeys("My Name is Teo");
//            jsPrompt.accept();
            handleAlert(wait, triggerPromptBtnElem, "My name is Teo! ");
            System.out.println(driver.findElement(resultTextSel).getText());


        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    private static void handleAlert (WebDriverWait wait, WebElement alertElem, Boolean isAccept){
        alertElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if(isAccept) alert.accept();
        else alert.dismiss();
    }
    private static void handleAlert (WebDriverWait wait, WebElement alertElem, String inputText){
        alertElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(inputText);
        alert.accept();
    }
}
