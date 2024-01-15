package com.abeyis.demo.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public abstract class BasePage {

    public static WebDriver driver;
    public static Wait<WebDriver> wait;

    public static SoftAssert softAssert;
    public BasePage(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.driver = driver;
        softAssert = new SoftAssert();
        PageFactory.initElements(driver,this);
    }
    /**
     * This method enables to wait desired seconds
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(seconds));
    }

    /**
     * This method enables to wait visibility of the element
     *
     * @param element
     */
    public static void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method enables to wait clickable of the element
     *
     * @param element
     */
    public static void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method enables to wait for element to be selectable
     *
     * @param element
     */
    public void waitForElementToBeSelectable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    /**
     * This method enables to wait for page to be loaded
     *
     * @param seconds
     */
    public static void waitForPageToLoad(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    /**
     * This method enables to navigate desired URL
     *
     * @param url
     */
    public static void navigateTo_URL(String url) {
        driver.get(url);
    }

    /**
     * This method enables to click the element
     *
     * @param element
     */
    public static void click(WebElement element) {
        wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This method enables to enter text into inputBox
     *
     * @param element
     * @param keyword
     */
    public static void enterText(WebElement element, String keyword) {
        wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(keyword);
    }

    /**
     * This method enables to get text of the element
     *
     * @param element
     * @return
     */
    public static String getText(WebElement element) {
        wait.until(driver -> ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * This method enables to get text of the elements and put them into list
     *
     * @param lists
     * @return
     */
    public static List<String> getListText(List<WebElement> lists) {
        wait.until(driver -> ExpectedConditions.visibilityOf(lists.get(0)));
        return lists.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }








}
