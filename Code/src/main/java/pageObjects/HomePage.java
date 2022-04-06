package main.java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends main.java.pageObjects.BasePage {

    @FindBy(xpath = "//*[@class='btn_mobile']")
    private WebElement hamburgerButton;

    @FindBy(xpath = "//*[@class='content_navigation']//*[contains(@class, 'btn_start_project')]")
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
