package test.java;

import main.java.PageObjects.GetInTouchFormPageElements;
import main.java.pageEvents.GetInTouchFormPageEvents;
import main.java.pageEvents.HomePageEvents;
import org.testng.annotations.Test;

public class SampleTest extends TestBase {

    @Test
    public void sampleMethodForNameEntering() {
        HomePageEvents homePage = new HomePageEvents();
        homePage.clickGetInTouchButton();

        GetInTouchFormPageEvents getInTouchFormPage = new GetInTouchFormPageEvents();
        getInTouchFormPage.enterName("Agustin");
    }
}
