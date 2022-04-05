package main.java.pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "btn_mobile")
    private WebElement hamburgerButton;

    @FindBy(how = How.XPATH, using = "//*[@class='content_navigation']//*[contains(@class, 'btn_start_project')]")
    private WebElement getInTouchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openGetInTouchForm() {
        if (isHamburgerButtonDisplayed()) {
            clickHamburgerMenuButton();
        }
        clickGetInTouchButton();
    }

    public void clickHamburgerMenuButton() {
        click(hamburgerButton);
    }

    public boolean isHamburgerButtonDisplayed() {
        return isElementDisplayed(hamburgerButton);
    }

    public void clickGetInTouchButton() {
        click(getInTouchButton);
    }

    public boolean isGetInTouchButtonEnabled() {
        return getInTouchButton.isEnabled();
    }
}
