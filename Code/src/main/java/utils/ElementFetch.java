package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.TestBase;

import java.util.List;

public class ElementFetch {

    WebDriver browser = TestBase.driver;

    public WebElement getWebElement(String identifierType, String identifierValue) {
        identifierType = identifierType.toLowerCase();
        switch (identifierType) {
            case "id":
                return browser.findElement(By.id(identifierValue));
            case "classname":
                return browser.findElement(By.className(identifierValue));
            case "name":
                return browser.findElement(By.name(identifierValue));
            case "cssselector":
                return browser.findElement(By.cssSelector(identifierValue));
            case "xpath":
                return browser.findElement(By.xpath(identifierValue));
            case "linktest":
                return browser.findElement(By.partialLinkText(identifierValue));
            case "tagname":
                return browser.findElement(By.tagName(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "id":
                return browser.findElements(By.id(identifierValue));
            case "className":
                return browser.findElements(By.className(identifierValue));
            case "name":
                return browser.findElements(By.name(identifierValue));
            case "cssSelector":
                return browser.findElements(By.cssSelector(identifierValue));
            case "xpath":
                return browser.findElements(By.xpath(identifierValue));
            case "linkTest":
                return browser.findElements(By.partialLinkText(identifierValue));
            case "tagName":
                return browser.findElements(By.tagName(identifierValue));
            default:
                return null;
        }
    }
}
