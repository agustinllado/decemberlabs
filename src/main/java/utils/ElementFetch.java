package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.TestBase;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        identifierType = identifierType.toLowerCase();
        switch (identifierType) {
            case "id":
                return TestBase.browser.findElement(By.id(identifierValue));
            case "classname":
                return TestBase.browser.findElement(By.className(identifierValue));
            case "name":
                return TestBase.browser.findElement(By.name(identifierValue));
            case "cssselector":
                return TestBase.browser.findElement(By.cssSelector(identifierValue));
            case "xpath":
                return TestBase.browser.findElement(By.xpath(identifierValue));
            case "linktest":
                return TestBase.browser.findElement(By.partialLinkText(identifierValue));
            case "tagname":
                return TestBase.browser.findElement(By.tagName(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "id":
                return TestBase.browser.findElements(By.id(identifierValue));
            case "className":
                return TestBase.browser.findElements(By.className(identifierValue));
            case "name":
                return TestBase.browser.findElements(By.name(identifierValue));
            case "cssSelector":
                return TestBase.browser.findElements(By.cssSelector(identifierValue));
            case "xpath":
                return TestBase.browser.findElements(By.xpath(identifierValue));
            case "linkTest":
                return TestBase.browser.findElements(By.partialLinkText(identifierValue));
            case "tagName":
                return TestBase.browser.findElements(By.tagName(identifierValue));
            default:
                return null;
        }
    }
}
