package com.abeyis.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public ToDoPage login(String email, String password){
        enterText(emailInput,email);
        enterText(passwordInput,password);
        click(submitButton);
        return new ToDoPage(driver);
    }
}
