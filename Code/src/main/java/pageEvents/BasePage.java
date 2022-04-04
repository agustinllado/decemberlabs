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
        waitForElementToBeClickable(element, 3);
        element.click();
    }

    protected void clickRadio(WebElement element) {
        waitForElementToBeVisible(element, 3);
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element, 2);
        element.sendKeys(text);
    }

    protected boolean isElementDisplayed(WebElement element) {
        waitForElementToBeVisible(element, 5);
        return element.isDisplayed();
    }

    private void waitForElementToBeClickable(WebElement element, int duration) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitForElementToBeVisible(WebElement element, int duration) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
