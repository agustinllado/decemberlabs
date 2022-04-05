package main.java.pageEvents;

import main.java.PageObjects.ConfirmationPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.TestBase;

import java.time.Duration;

public class ConfirmationPageEvents extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'content_success')]//*[contains(@class, 'row big_text')]")
    private WebElement thanksMessage;

    @FindBy(xpath="//*[contains(@class, 'content_success')]//*[contains(@class, 'close-modal-success')]")
    private WebElement okButton;

    public ConfirmationPageEvents(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOk() {
        click(okButton);
    }
}
