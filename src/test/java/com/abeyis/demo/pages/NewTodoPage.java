package com.abeyis.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class NewTodoPage extends BasePage{
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[data-testid='new-todo']")
    private WebElement toDoItemInput;

    @FindBy(css = "button[data-testid='submit-newTask']")
    private WebElement createToD0Button;

    @FindBy(css = "h2[data-testid='header']")
    private WebElement createNewTODOHeader;

    @FindBy(css = "h2[data-testid='sub-header']")
    private WebElement readyToMarkText;

    public NewTodoPage verifyCreateNewTodoHeader(String text){
        assertEquals(getText(createNewTODOHeader),text);
        return this;
    }

    public NewTodoPage verifyReadyToMarkSubHeader(String text){
        assertEquals(getText(readyToMarkText),text);
        return this;
    }

    public NewTodoPage enterToDoItem(String text){
        enterText(toDoItemInput,text);
        return this;
    }

    public ToDoPage clickCreateTodoButton(){
        click(createToD0Button);
        return new ToDoPage(driver);
    }



}
