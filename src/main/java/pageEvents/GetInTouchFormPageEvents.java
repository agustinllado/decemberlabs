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
}
