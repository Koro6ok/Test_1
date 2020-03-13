package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait5;

    public ActionsWithOurElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        wait5 = new WebDriverWait(webDriver, 5);
    }


    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into Input");

        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            wait5.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }

    }

    public void selectGenderInDD(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info("Text was selected in DD");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public void selectAgeInDD(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info("Text was selected in DD");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }
}