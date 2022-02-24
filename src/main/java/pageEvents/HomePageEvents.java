package main.java.pageEvents;

import main.java.PageObjects.HomePageElements;
import main.java.utils.ElementFetch;

public class HomePageEvents extends BasePage{

    public HomePageEvents() {
    }

    public void clickGetInTouchButton() {
        elementFetch.getWebElement("cssSelector", HomePageElements.getInTouchButton).click();
    }
}
