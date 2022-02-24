package main.java.pageEvents;

import main.java.PageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import org.testng.Assert;

public class HomePageEvents extends BasePage{

    public HomePageEvents() {
        locateControls();
    }

    private void locateControls() {
        Assert.assertTrue(isGetInTouchButtonEnabled(), "Unable to locate Get In Touch button");
    }

    public void clickGetInTouchButton() {
        elementFetch.getWebElement("cssSelector", HomePageElements.getInTouchButton).click();
    }

    public boolean isGetInTouchButtonEnabled() {
        return elementFetch.getWebElement("cssselector", HomePageElements.getInTouchButton).isEnabled();
    }
}
