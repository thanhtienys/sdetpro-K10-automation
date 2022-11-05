package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormInteractionMultipleMatching {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            //Define selector values - lúc nào cũng được
            By inputFieldSel = By.tagName("input");
            //Tim ra nhiu KQ nhung chi tra ve cai dau tien
            WebElement usernameElem = driver.findElement(inputFieldSel);
            //Tim ra nhiu KQ chua trong list
            // Note : findElements khong vang loi, chi tra ve list null . Can check list rong
            // Dung de check case tim item no display in page
            List<WebElement> inputFieldsElem = driver.findElements(inputFieldSel);
            if (inputFieldsElem.isEmpty()){
                throw new RuntimeException("[ERROR] There is no input fields");
            }

            // O,1 khi doc rat kho hieu, can tao bien de quy dinh
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            inputFieldsElem.get(USERNAME_INDEX).sendKeys("tomsmith");
            inputFieldsElem.get(PASSWORD_INDEX).sendKeys("SuperSecretPassword!");



            //Debug purpose ONLY
            Thread.sleep(3000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();


    }

}
