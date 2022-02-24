package main.java.pageEvents;

import main.java.PageObjects.GetInTouchFormPageElements;
import main.java.utils.ElementFetch;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GetInTouchFormPageEvents extends BasePage {

    public GetInTouchFormPageEvents() {
        locateControls();
    }

    public void locateControls() {
        Assert.assertTrue(elementFetch.getWebElement("id", GetInTouchFormPageElements.nameText).isEnabled(), "Unable to locate name field");
        Assert.assertTrue(elementFetch.getWebElement("id", GetInTouchFormPageElements.emailText).isEnabled(), "Unable to locate email field");
        Assert.assertTrue(elementFetch.getWebElement("id", GetInTouchFormPageElements.companyText).isEnabled(), "Unable to locate company field");
        Assert.assertTrue(elementFetch.getWebElement("id", GetInTouchFormPageElements.messageText).isEnabled(), "Unable to locate message field");
        Assert.assertTrue(elementFetch.getWebElement("cssselector", GetInTouchFormPageElements.sendButton).isEnabled(), "Unable to locate submit button");
    }

    public void enterName(String name) {
        WebElement nameField = elementFetch.getWebElement("id", GetInTouchFormPageElements.nameText);
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        WebElement emailField = elementFetch.getWebElement("id", GetInTouchFormPageElements.emailText);
        emailField.sendKeys(email);
    }

    public void enterCompany(String company) {
        WebElement companyField = elementFetch.getWebElement("id", GetInTouchFormPageElements.companyText);
        companyField.sendKeys(company);
    }

    public void enterMessage(String message) {
        WebElement messageField = elementFetch.getWebElement("id", GetInTouchFormPageElements.messageText);
        messageField.sendKeys(message);
    }

    public void selectBudget(String budget) {
        WebElement budgetRadio = elementFetch.getWebElement("cssselector", String.format(GetInTouchFormPageElements.budgetRadio, budget));
        budgetRadio.click();
    }

    public void selectHearAboutUs(String intermediate) {
        WebElement intermediateRadio = elementFetch.getWebElement("cssselector", String.format(GetInTouchFormPageElements.hearUsRadio, intermediate));
        intermediateRadio.click();
    }

    public boolean isNamePromptDisplayed() {
        return elementFetch.getWebElement("cssselector", GetInTouchFormPageElements.nameTextWarning).isEnabled();
    }

    public boolean isEmailPromptDisplayed() {
        return elementFetch.getWebElement("cssselector", GetInTouchFormPageElements.emailTextWarning).isEnabled();
    }

    public boolean isMessagePromptDisplayed() {
        return elementFetch.getWebElement("cssselector", GetInTouchFormPageElements.messageTextWarning).isEnabled();
    }

    public void submit() {
        WebElement submitButton = elementFetch.getWebElement("cssselector", GetInTouchFormPageElements.sendButton);
        submitButton.click();
    }
}
