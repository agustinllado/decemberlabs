package test.java;

import main.java.pageEvents.ConfirmationPageEvents;
import main.java.pageEvents.GetInTouchFormPage;
import main.java.pageEvents.HomePage;
import main.java.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SampleTest extends TestBase {

    @Test
    public void getInTouchHappyPathTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openGetInTouchForm();

        GetInTouchFormPage getInTouchFormPage = new GetInTouchFormPage(driver);
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectBudget("50K-100K");
        getInTouchFormPage.selectHearAboutUs("Google");
        getInTouchFormPage.submit();

        ConfirmationPageEvents confirmationPageEvents = new ConfirmationPageEvents(driver);
        confirmationPageEvents.clickOk();

        Assert.assertTrue(homePage.isGetInTouchButtonEnabled(), "Get in touch button is not displayed");
    }

    @Test
    public void emptyBudgetTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openGetInTouchForm();

        GetInTouchFormPage getInTouchFormPage = new GetInTouchFormPage(driver);
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectHearAboutUs("Word-of-mouth");
        getInTouchFormPage.submit();

        ConfirmationPageEvents confirmationPageEvents = new ConfirmationPageEvents(driver);
        confirmationPageEvents.clickOk();

        Assert.assertTrue(homePage.isGetInTouchButtonEnabled(), "Get in touch button is not displayed");
    }

    @Test
    public void emptyHearAboutUsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openGetInTouchForm();

        GetInTouchFormPage getInTouchFormPage = new GetInTouchFormPage(driver);
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectBudget("100K-200K");
        getInTouchFormPage.submit();

        ConfirmationPageEvents confirmationPageEvents = new ConfirmationPageEvents(driver);
        confirmationPageEvents.clickOk();

        Assert.assertTrue(homePage.isGetInTouchButtonEnabled(), "Get in touch button is not displayed");
    }

    @Test
    public void emptyNameValidationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openGetInTouchForm();

        GetInTouchFormPage getInTouchFormPage = new GetInTouchFormPage(driver);
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectBudget("Below 25K");
        getInTouchFormPage.selectHearAboutUs("Social");
        getInTouchFormPage.submit();

        Assert.assertTrue(getInTouchFormPage.isNamePromptDisplayed(), "Name prompt is not displayed");
    }

    @Test
    public void emptyEmailValidationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openGetInTouchForm();

        GetInTouchFormPage getInTouchFormPage = new GetInTouchFormPage(driver);
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.enterMessage("Test message");
        getInTouchFormPage.selectBudget("25K-50K");
        getInTouchFormPage.selectHearAboutUs("Events");
        getInTouchFormPage.submit();

        Assert.assertTrue(getInTouchFormPage.isEmailPromptDisplayed(), "Email prompt is not displayed");
    }

    @Test
    public void emptyMessageValidationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openGetInTouchForm();

        GetInTouchFormPage getInTouchFormPage = new GetInTouchFormPage(driver);
        getInTouchFormPage.enterName("Agustin");
        getInTouchFormPage.enterEmail(Constants.email);
        getInTouchFormPage.enterCompany("The testing company");
        getInTouchFormPage.selectBudget("Above 200K");
        getInTouchFormPage.selectHearAboutUs("Recommendation");
        getInTouchFormPage.submit();

        Assert.assertTrue(getInTouchFormPage.isMessagePromptDisplayed(), "Message prompt is not displayed");
    }
}
