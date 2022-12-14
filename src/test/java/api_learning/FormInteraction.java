package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormInteraction {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            //Define selector values - lúc nào cũng được
            By usernameSel = By.id("username");
            By passwordSel = By.id("password");
            By loginBtnSel = By.cssSelector("button[type='submit']");

            /* id convert to css add #
            By usernameSel = By.cssSelector("#username");
            By passwordSel = By.cssSelector("#password");
             */

            // Find elements - chỉ tìm khi đang ở page đó
            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            //Interact with elements
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            //loginBtnElem.click();

            // Refresh page
            driver.navigate().refresh();
            //Re-input | After refresh the page load new DOM tree, so need to re-find element
            usernameElem = driver.findElement(usernameSel);
            passwordElem = driver.findElement(passwordSel);
            loginBtnElem = driver.findElement(loginBtnSel);
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();

            // User Dashboard page
            By headingSel = By.tagName("h2");  // By headingSel = By.cssSelector("h2");
            //Wait for only the element
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
            wait.until(ExpectedConditions.visibilityOfElementLocated(headingSel));

            WebElement headingElem = driver.findElement(headingSel);
            System.out.println("Heading Title:" + headingElem.getText());

            //Find by link text, partial link text
            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getText());
            System.out.println(driver.findElement(By.partialLinkText("Elemental")).getText());
            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getAttribute("href"));
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());


            //Debug purpose ONLY
            Thread.sleep(3000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();


    }

}
