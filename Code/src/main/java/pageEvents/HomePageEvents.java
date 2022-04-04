package main.java.pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageEvents extends BasePage {

    protected static WebDriver driver;

    @FindBy(xpath="//*[@class='content_navigation']//*[contains(@class, 'btn_start_project')]")
    private WebElement getInTouchButton;

    public HomePageEvents() { //remove this after pagefactory implementation
        locateControls();
    }

    public HomePageEvents(WebDriver driver) {
        PageFactory.initElements(driver, this);
        locateControls();
        this.driver = driver;
    }

    private void locateControls() {
        Assert.assertTrue(isGetInTouchButtonEnabled(), "Unable to locate Get In Touch button");
    }

    public void clickGetInTouchButton() {
        click(getInTouchButton);
    }

    public boolean isGetInTouchButtonEnabled() {
        return getInTouchButton.isEnabled();
    }
}
