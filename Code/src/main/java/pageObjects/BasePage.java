package main.java.pageObjects;

import main.java.utils.ElementFetch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    // ACTIONS
    protected void click(WebElement element) {
        try {
            waitForElementToBeVisible(element, 3);
            waitForElementToBeClickable(element, 3);
            scrollToView(element);
            element.click();
        } catch (ElementClickInterceptedException ex) {
            javascriptClick(element);
        }
    }

    protected void clickRadio(WebElement element) {
        waitForElementToBeVisible(element, 3);
        waitForElementToBeClickable(element, 3);
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element, 2);
        element.sendKeys(text);
    }

    public void scrollToView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void javascriptClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    // VALIDATIONS
    protected boolean isElementDisplayed(WebElement element) {
        waitForElementToBeVisible(element, 5);
        return element.isDisplayed();
    }

    // WAITS
    private void waitForElementToBeClickable(WebElement element, int duration) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitForElementToBeVisible(WebElement element, int duration) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element));
    }



}
