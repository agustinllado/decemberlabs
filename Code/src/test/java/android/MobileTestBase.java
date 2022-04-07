package test.java.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.utils.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTestBase {
    
    AppiumDriver driver;

    @FindBy(xpath = "//*[@class='btn_mobile']")
    private WebElement hamburgerButton;

    @FindBy(how = How.XPATH, using = "//*[@class='content_navigation']//*[contains(@class, 'btn_start_project')]")
    private WebElement getInTouchButton;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        caps.setCapability("chromedriverExecutableDir", System.getProperty("user.dir") + "/drivers/mobile");

        //For running apps
    //    caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/apps/contacts.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url, caps);
    }

    @BeforeMethod
    public void beforeMethodTest() {
        driver.get(Constants.url);
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

    @AfterTest
    public void teardown() {

    }
}
