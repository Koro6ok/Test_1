package registration;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;


public class Registration extends BasedTest {

    @Test
    public void registration() throws InterruptedException {

        //When
        registrationPage.openRegistrationPage();
        registrationPage.clickOnPhotoGirls();
        registrationPage.clickOnPhotoDarkHairGirls();
        registrationPage.clickOnPhotoLightEyesGirls();
        registrationPage.clickOnPhotoSlimGirls();
        registrationPage.fillRegistrationForm("qwe", System.currentTimeMillis() + "@testmail.com");
        registrationPage.selectGenderInDD("Парень");
        registrationPage.selectAgeInDD("30");
        registrationPage.clickOnButtonRegistration();
        homePage.clickOnButtonCloseHitwePopup();
        homePage.clickOnAvatar();
        homePage.uploadPhotoFromComputer();
        homePage.clickOnButtonClose();

        //Then
            assertThat(homePage.getCurentAvatarClass(),
                    CoreMatchers.not(CoreMatchers.containsString(" no-photo")));
    }
}