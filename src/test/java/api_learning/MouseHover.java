package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import javax.swing.*;
import java.util.List;

public class MouseHover {

    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(Urls.BASE_URL.concat(Urls.HOVER_SLUG));

            //Locate all imageElems
            List<WebElement> figureElems = driver.findElements(figureSel);
            if (figureElems.isEmpty()) {
                throw new RuntimeException("[ERR] There is no figure to test!");
            }

            //Mouse hover and locate the username and profile links
            Actions actions = new Actions(driver);
            for (WebElement figureElem : figureElems) {
                WebElement profileNameElem = figureElem.findElement(profileNameSel);
                WebElement profileLinkElem = figureElem.findElement(profileLinkSel);

                //BEFORE mouse hover
                System.out.println(profileNameElem.getText() + ": " + profileLinkElem.isDisplayed());
                // Mouse hover
                actions.moveToElement(figureElem).perform();
                //AFTER mouse hover
                System.out.println("====After mouse hover =======");
                System.out.println(profileNameElem.getText() + ": " + profileLinkElem.isDisplayed());
            }

            //DEBUG purpose only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
