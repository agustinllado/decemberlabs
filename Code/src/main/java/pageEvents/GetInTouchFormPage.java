package main.java.pageEvents;

import main.java.PageObjects.GetInTouchFormPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GetInTouchFormPage extends BasePage {

    @FindBy(id="name")
    private WebElement nameText;

    @FindBy(id="email")
    private WebElement emailText;

    @FindBy(id="company")
    private WebElement companyText;

    @FindBy(id="message")
    private WebElement messageText;

    @FindBy(xpath="//*[@id='budget']//*[@value='Below $25K']")
    private WebElement below25KBudgetRadio;

    @FindBy(xpath="//*[@id='budget']//*[@value='$25K-$50K']")
    private WebElement between25And50kBudgetRadio;

    @FindBy(xpath="//*[@id='budget']//*[@value='$50K-$100K']")
    private WebElement between50And100kBudgetRadio;

    @FindBy(xpath="//*[@id='budget']//*[@value='$100K-$200K']")
    private WebElement between100And200kBudgetRadio;

    @FindBy(xpath="//*[@id='budget']//*[@value='Above $200K']")
    private WebElement above200kBudgetRadio;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Google']")
    private WebElement hearusGoogle;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Social']")
    private WebElement hearusSocial;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Events']")
    private WebElement hearusEvents;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Recommendation']")
    private WebElement hearusRecommendation;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Word-of-mouth']")
    private WebElement hearusWordOfMouth;

    @FindBy(xpath = "//*[@id='hearus']//*[@value='Other']")
    private WebElement hearusOther;

    @FindBy(css = ".warning #name")
    private WebElement nameTextWarning;

    @FindBy(css = ".warning #email")
    private WebElement emailTextWarning;

    @FindBy(css = ".warning #message")
    private WebElement messageTextWarning;

    @FindBy(className = ".contact-form-submit")
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
