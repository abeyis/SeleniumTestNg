package com.abeyis.demo.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ToDoPage extends BasePage {
    public ToDoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2[data-testid='welcome']")
    private WebElement welcomeMessage;

    @FindBy(css = "button[class='MuiButtonBase-root MuiIconButton-root']")
    private WebElement addNewToDoButton;

    @FindBy(css = "h2[data-testid='todo-text']")
    private WebElement todoText;

    @FindBy(css = "input[type='checkbox']")
    private WebElement completeTaskCheckBox;

    @FindBy(css = "button[data-testid='delete']")
    private WebElement deleteButton;

    @FindBy(css = "h4[data-testid='no-todos']")
    private WebElement noToDosText;

    @FindBy(xpath = "//span[text()=\"Logout\"]")
    private WebElement logOutButton;

    public ToDoPage verifyWelcomeMessage() {
        assertTrue(
                getText(welcomeMessage).contains("GOOD") || getText(welcomeMessage).contains("TIME TO SLEEP")
        );
        return this;
    }

    public NewTodoPage clickAddNewTodoButton() {
        click(addNewToDoButton);
        return new NewTodoPage(driver);
    }

    public ToDoPage verifyAddedTask(String text) {
        assertEquals(getText(todoText), text);
        return this;
    }

    public ToDoPage clickCheckBox() {
        click(completeTaskCheckBox);
        return this;
    }

    public ToDoPage clickDeleteButton() {
        click(deleteButton);
        return this;
    }

    public ToDoPage verifyNoToDosMessage() {
        assertTrue(noToDosText.isDisplayed());
        return this;
    }

    public LoginPage addCookie(String accessToken, WebDriver driver, String url, String todoURL){
        navigateTo_URL(url);
        Cookie cookie = new Cookie("access_token", accessToken);
        driver.manage().addCookie(cookie);
        navigateTo_URL(todoURL);
        return new LoginPage(driver);
    }

    public ToDoPage verifyLogoutButton(){
        waitForClickable(logOutButton);
        assertTrue(logOutButton.isDisplayed());
        return this;
    }


}
