package test.java;

import main.java.pageEvents.ConfirmationPageEvents;
import main.java.pageEvents.GetInTouchFormPageEvents;
import main.java.pageEvents.HomePageEvents;
import main.java.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends TestBase {

    @Test
    public void getInTouchHappyPathTest() {
        HomePageEvents homePage = new HomePageEvents(browser);
        homePage.clickGetInTouchButton();

        GetInTouchFormPageEvents getInTouchFormPage = new GetInTouchFormPageEvents();
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectBudget("$50K-$100K");
        getInTouchFormPage.selectHearAboutUs("Google");
        getInTouchFormPage.submit();

        ConfirmationPageEvents confirmationPageEvents = new ConfirmationPageEvents();
        confirmationPageEvents.clickOk();

        Assert.assertTrue(homePage.isGetInTouchButtonEnabled(), "Get in touch button is not displayed");
    }

    @Test
    public void emptyBudgetTest() {
        HomePageEvents homePage = new HomePageEvents(browser);
        homePage.clickGetInTouchButton();

        GetInTouchFormPageEvents getInTouchFormPage = new GetInTouchFormPageEvents();
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectHearAboutUs("Word-of-mouth");
        getInTouchFormPage.submit();

        ConfirmationPageEvents confirmationPageEvents = new ConfirmationPageEvents();
        confirmationPageEvents.clickOk();

        Assert.assertTrue(homePage.isGetInTouchButtonEnabled(), "Get in touch button is not displayed");
    }

    @Test
    public void emptyHearAboutUsTest() {
        HomePageEvents homePage = new HomePageEvents(browser);
        homePage.clickGetInTouchButton();

        GetInTouchFormPageEvents getInTouchFormPage = new GetInTouchFormPageEvents();
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectBudget("$100K-$200K");
        getInTouchFormPage.submit();

        ConfirmationPageEvents confirmationPageEvents = new ConfirmationPageEvents();
        confirmationPageEvents.clickOk();

        Assert.assertTrue(homePage.isGetInTouchButtonEnabled(), "Get in touch button is not displayed");
    }

    @Test
    public void emptyNameValidationTest() {
        HomePageEvents homePage = new HomePageEvents(browser);
        homePage.clickGetInTouchButton();

        GetInTouchFormPageEvents getInTouchFormPage = new GetInTouchFormPageEvents();
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectBudget("Below $25K");
        getInTouchFormPage.selectHearAboutUs("Social");
        getInTouchFormPage.submit();

        Assert.assertTrue(getInTouchFormPage.isNamePromptDisplayed(), "Name prompt is not displayed");
    }

    @Test
    public void emptyEmailValidationTest() {
        HomePageEvents homePage = new HomePageEvents(browser);
        homePage.clickGetInTouchButton();

        GetInTouchFormPageEvents getInTouchFormPage = new GetInTouchFormPageEvents();
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectBudget("$25K-$50K");
        getInTouchFormPage.selectHearAboutUs("Events");
        getInTouchFormPage.submit();

        Assert.assertTrue(getInTouchFormPage.isEmailPromptDisplayed(), "Email prompt is not displayed");
    }

    @Test
    public void emptyMessageValidationTest() {
        HomePageEvents homePage = new HomePageEvents(browser);
        homePage.clickGetInTouchButton();

        GetInTouchFormPageEvents getInTouchFormPage = new GetInTouchFormPageEvents();
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.selectBudget("Above $200K");
        getInTouchFormPage.selectHearAboutUs("Recommendation");
        getInTouchFormPage.submit();

        Assert.assertTrue(getInTouchFormPage.isMessagePromptDisplayed(), "Message prompt is not displayed");
    }
}
