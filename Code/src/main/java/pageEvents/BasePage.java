package main.java.pageEvents;

import main.java.utils.ElementFetch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    ElementFetch elementFetch;
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BasePage() {
        if (elementFetch == null) {
            elementFetch = new ElementFetch();
        }
    }

    protected void click(WebElement element) {
        waitForElementToBeClickable(element, 2);
    }

    private void waitForElementToBeClickable(WebElement element, int duration) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
