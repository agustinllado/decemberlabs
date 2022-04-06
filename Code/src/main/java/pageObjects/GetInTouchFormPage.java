package main.java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetInTouchFormPage extends main.java.pageObjects.BasePage {

    @FindBy(xpath = "//*[@id='name']")
    private WebElement nameText;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailText;

    @FindBy(xpath = "//*[@id='company']")
    private WebElement companyText;

    @FindBy(xpath = "//*[@id='message']")
    private WebElement messageText;

    @FindBy(xpath = "//*[@id='budget']//*[@value='Below $25K']//ancestor::*[@class='radio']")
    private WebElement below25KBudgetRadio;

    @FindBy(xpath = "//*[@id='budget']//*[@value='$25K-$50K']//ancestor::*[@class='radio']")
    private WebElement between25And50kBudgetRadio;

    @FindBy(xpath = "//*[@id='budget']//*[@value='$50K-$100K']//ancestor::*[@class='radio']")
    private WebElement between50And100kBudgetRadio;

    @FindBy(xpath = "//*[@id='budget']//*[@value='$100K-$200K']//ancestor::*[@class='radio']")
    private WebElement between100And200kBudgetRadio;

    @FindBy(xpath = "//*[@id='budget']//*[@value='Above $200K']//ancestor::*[@class='radio']")
    private WebElement above200kBudgetRadio;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Google']//ancestor::*[@class='radio']")
    private WebElement hearusGoogle;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Social']//ancestor::*[@class='radio']")
    private WebElement hearusSocial;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Events']//ancestor::*[@class='radio']")
    private WebElement hearusEvents;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Recommendation']//ancestor::*[@class='radio']")
    private WebElement hearusRecommendation;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Word-of-mouth']//ancestor::*[@class='radio']")
    private WebElement hearusWordOfMouth;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Other']//ancestor::*[@class='radio']")
    private WebElement hearusOther;

    @FindBy(xpath = "//*[contains(@class, 'warning')]//*[@id='name']")
    private WebElement nameTextWarning;

    @FindBy(xpath = "//*[contains(@class, 'warning')]//*[@id='email']")
    private WebElement emailTextWarning;

    @FindBy(xpath = "//*[contains(@class, 'warning')]//*[@id='message']")
    private WebElement messageTextWarning;

    @FindBy(xpath = "//*[contains(@class,'submit')]")
    private WebElement sendButton;

    public GetInTouchFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        sendKeys(nameText, name);
    }

    public void enterEmail(String email) {
        sendKeys(emailText, email);
    }

    public void enterCompany(String company) {
        sendKeys(companyText, company);
    }

    public void enterMessage(String message) {
        sendKeys(messageText, message);
    }

    public void selectBudget(String budget) {
        WebElement budgetRadio;
        switch (budget) {
            case "Below 25K":
                budgetRadio = below25KBudgetRadio;
                break;
            case "25K-50K":
                budgetRadio = between25And50kBudgetRadio;
                break;
            case "50K-100K":
                budgetRadio = between50And100kBudgetRadio;
                break;
            case "100K-200K":
                budgetRadio = between100And200kBudgetRadio;
                break;
            default:
                budgetRadio = above200kBudgetRadio;
                break;
        }
        clickRadio(budgetRadio);
    }

    public void selectHearAboutUs(String intermediate) {
        WebElement intermediateRadio;
        switch (intermediate) {
            case "Google":
                intermediateRadio = hearusGoogle;
                break;
            case "Social":
                intermediateRadio = hearusSocial;
                break;
            case "Recommendation":
                intermediateRadio = hearusRecommendation;
                break;
            case "Events":
                intermediateRadio = hearusEvents;
                break;
            case "Word-of-mouth":
                intermediateRadio = hearusWordOfMouth;
                break;
            default:
                intermediateRadio = hearusOther;
                break;
        }
        clickRadio(intermediateRadio);
    }

    public boolean isNamePromptDisplayed() {
        return isElementDisplayed(nameTextWarning);
    }

    public boolean isEmailPromptDisplayed() {
        return isElementDisplayed(emailTextWarning);
    }

    public boolean isMessagePromptDisplayed() {
        return isElementDisplayed(messageTextWarning);
    }

    public void submit() {
        click(sendButton);
    }
}
