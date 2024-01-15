package com.abeyis.demo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "input[data-testid='first-name']")
    private WebElement firstNameInput;

    @FindBy(css = "input[data-testid='last-name']")
    private WebElement lastNameInput;

    @FindBy(css ="input[data-testid='email']" )
    private WebElement emailInput;

    @FindBy(css = "input[data-testid='password']")
    private WebElement passwordInput;

    @FindBy(css = "input[data-testid='confirm-password']")
    private WebElement confirmPasswordInput;

    @FindBy(css = "button[data-testid='submit']")
    private WebElement submitButton;

    public RegisterPage loadPage(String url){
        navigateTo_URL(url);
        return this;

    }

    public RegisterPage enterFirstName(String firstName){
        enterText(firstNameInput,firstName);
        return this;
    }
    public RegisterPage enterLastName(String lastName){
        enterText(lastNameInput,lastName);
        return this;
    }
    public RegisterPage enterEmail(String email){
        enterText(emailInput,email);
        return this;
    }
    public RegisterPage enterPassword(String password){
        enterText(passwordInput,password);
        return this;
    }
    public RegisterPage enterConfirmPassword(String password){
       enterText(confirmPasswordInput,password);
       return this;
    }
    public ToDoPage clickSubmitButton(){
        click(submitButton);
        return new ToDoPage(driver);
    }

    @Step("Step 1: Register ")
    public void step1(){
       enterFirstName("ali");
    }








}
