package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='interstial-close']")
    private WebElement buttonCloseHitwePopup;

    @FindBy(xpath = ".//*[contains(@class,'prof_add_avatar')]")
    private WebElement avatar;

    @FindBy(xpath = ".//*[@class='close']")
    private WebElement buttonClose;

    @FindBy(xpath = ".//*[contains(@class,'avatar-placeholder')]")
    private WebElement avatarImage;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonCloseHitwePopup() {
        actionsWithOurElements.clickOnElement(buttonCloseHitwePopup);
    }

    public void clickOnAvatar() throws InterruptedException {
        Thread.sleep(10000);
        actionsWithOurElements.clickOnElement(avatar);
    }

    public void uploadPhotoFromComputer() {
        try {
            Thread.sleep(3000);
            WebElement fileInput = webDriver.findElement(By.xpath(".//input[contains(@type,'file')]"));
            fileInput.sendKeys("C:\\Git_2\\src\\main\\resources\\thousand.jpg");
            logger.info("Photo was added ");
        } catch (Exception e) {
            logger.error("Cannot added Photo " + e);
            Assert.fail("Cannot added Photo " + e);
        }
    }

    public void clickOnButtonClose() throws InterruptedException {
        Thread.sleep(1000);
        actionsWithOurElements.clickOnElement(buttonClose);
    }

    public String getCurentAvatarClass() {
        webDriver.navigate().refresh();
        return avatarImage.getAttribute("class");
    }
}


