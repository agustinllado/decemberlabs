package main.java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends main.java.pageObjects.BasePage {

    @FindBy(xpath = "//*[contains(@class, 'content_success')]//*[contains(@class, 'row big_text')]")
    private WebElement thanksMessage;

    @FindBy(xpath="//*[contains(@class, 'content_success')]//*[contains(@class, 'close-modal-success')]")
    private WebElement okButton;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOk() {
        click(okButton);
    }
}
