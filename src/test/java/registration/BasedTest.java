package registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.RegistrationPage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class BasedTest {
    private WebDriver webDriver;
    protected RegistrationPage registrationPage;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        final String browser = System.getProperty("browser");
        driverInit(browser);
        registrationPage = new RegistrationPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @AfterMethod
    public void tearDown() {

        webDriver.quit();
    }

    private void driverInit(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");

        if ("chrome".equals(browser) || browser == null) {
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver(capabilities);

        } else if ("firefox".equals(browser)) {
            File file = new File("./src/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore");
            webDriver = new FirefoxDriver(capabilities);

        } else {
            Assert.fail("Wrong browser name");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS).implicitlyWait(10, TimeUnit.SECONDS);
    }
}
