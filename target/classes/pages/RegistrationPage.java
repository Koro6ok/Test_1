package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends ParentPage {

    @FindBy(xpath = ".//*[@style='background-image: url( https://static.hitwe.com/hitwe/images/landing/landing-inter/ru/f.jpg);']")
    private WebElement photoGirls;

    @FindBy(xpath = ".//*[@src='https://static.hitwe.com/hitwe/images/landing/landing-inter/ru/2-female-black.jpg']")
    private WebElement photoDarkHairGirls;

    @FindBy(xpath = ".//*[@src='https://static.hitwe.com/hitwe/images/landing/landing-inter/ru/3-female-lighteyed.jpg']")
    private WebElement photoLightEyesGirls;

    @FindBy(xpath = ".//*[@src='https://static.hitwe.com/hitwe/images/landing/landing-inter/ru/4-female-thin.jpg']")
    private WebElement photoSlimGirls;

    @FindBy(xpath = ".//input[@name = 'name']")
    private WebElement inputName;

    @FindBy(name = "email")
    private WebElement inputEmailAddress;

    @FindBy(name = "gender")
    private WebElement typeOfGenderDD;

    @FindBy(name = "age")
    private WebElement ageDD;

    @FindBy(xpath = ".//*[@type='submit']")
    private WebElement buttonRegistration;


    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openRegistrationPage() {
        try {
            webDriver.get("https://m.hitwe.com/landing/inter?p=15276");
            logger.info("Registration page was opened");

        } catch (Exception e) {
            logger.info("Cannot open Registration Page");
            Assert.fail("Cannot open Registration Page");
        }
    }


    public void clickOnPhotoGirls() {
        actionsWithOurElements.clickOnElement(photoGirls);
    }

    public void clickOnPhotoDarkHairGirls() {
        actionsWithOurElements.clickOnElement(photoDarkHairGirls);
    }

    public void clickOnPhotoLightEyesGirls() {
        actionsWithOurElements.clickOnElement(photoLightEyesGirls);
    }

    public void clickOnPhotoSlimGirls() {
        actionsWithOurElements.clickOnElement(photoSlimGirls);
    }

    public void enterName(String name) throws InterruptedException {
        Thread.sleep(1000);
        actionsWithOurElements.enterTextInToElement(inputName, name);
    }

    public void enterEmailAddress(String email) {
        actionsWithOurElements.enterTextInToElement(inputEmailAddress, email);
    }

    public void selectGenderInDD(String gender) {
        actionsWithOurElements.selectGenderInDD(typeOfGenderDD, gender);
    }

    public void selectAgeInDD(String age) {
        actionsWithOurElements.selectAgeInDD(ageDD, age);
    }

    public void clickOnButtonRegistration() {

        actionsWithOurElements.clickOnElement(buttonRegistration);
    }

    public void fillRegistrationForm(String name, String email) throws InterruptedException {
        enterName(name);
        enterEmailAddress(email);
    }
}