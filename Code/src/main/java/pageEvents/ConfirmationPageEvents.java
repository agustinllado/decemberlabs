package main.java.pageEvents;

import main.java.PageObjects.ConfirmationPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.TestBase;

import java.time.Duration;

public class ConfirmationPageEvents extends BasePage {

    public ConfirmationPageEvents() {
        locateControls();
    }

    public void locateControls() {
        Assert.assertTrue(elementFetch.getWebElement("cssselector", ConfirmationPageElements.thanksMessage).isEnabled(), "Unable to locate success message");
        Assert.assertTrue(elementFetch.getWebElement("cssselector", ConfirmationPageElements.okButton).isEnabled(), "Unable to locate ok button");
    }

    public void clickOk() {
        WebDriverWait webDriverWait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ConfirmationPageElements.okButton)));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementFetch.getWebElement("cssselector", ConfirmationPageElements.okButton).click();
    }
}
