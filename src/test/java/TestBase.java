package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    public static WebDriver browser;
    public ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    public static String userDir = System.getProperty("user.dir");

    @BeforeTest
    public void beforeTestMethod() {
        htmlReporter = new ExtentSparkReporter(userDir + File.separator + "reports" + File.separator + "AutomationReport.html");
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Agustin Llado");
    }

    @BeforeMethod
    @Parameters(value={"browserName"})
    public void beforeMethodMethod(String browserName, Method testMethod) {
        logger = extent.createTest(testMethod.getName());
        setupDriver(browserName);
        browser.manage().window().maximize();
        browser.get(Constants.url);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + "Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, markup);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, markup);
        } else if (result.getStatus() == ITestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Skipped";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP, markup);
        }
        browser.quit();
    }

    @AfterTest
    public void afterTestTest() {
        extent.flush();
    }

    public void setupDriver(String browserName) {
        String route = userDir + File.separator + "drivers" + File.separator + "%s";
        switch (browserName) {
            case "firefox":
                break;
            case "safari":
                break;
            case "edge":
                break;
            default:
                System.setProperty("webdriver.chrome.driver", String.format(route, "chromedriver"));
                browser = new ChromeDriver();
                break;
        }
    }
}
