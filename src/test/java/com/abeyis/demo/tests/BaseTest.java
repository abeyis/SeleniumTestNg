package com.abeyis.demo.tests;

import com.abeyis.demo.apis.apitests.RegisterApi;
import com.abeyis.demo.constants.FrameworkConstants;
import com.abeyis.demo.driver.Driver;
import com.abeyis.demo.driver.DriverManager;
import com.abeyis.demo.pages.NewTodoPage;
import com.abeyis.demo.pages.RegisterPage;
import com.abeyis.demo.pages.ToDoPage;
import com.github.javafaker.Faker;
import org.testng.annotations.*;

public class BaseTest {

    protected BaseTest() {
    }

    protected RegisterPage registerPage;
    protected ToDoPage toDoPage;
    protected NewTodoPage newTodoPage;
    protected Faker faker;
    protected String url;
    protected String herOkuUrl;
    protected String todoUrl;
    protected String createNewToDoText;
    protected String readyToMark;
    protected String todoItem;
    protected String email;
    protected String accessToken;




    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
        registerPage = new RegisterPage(DriverManager.getDriver());
        toDoPage = new ToDoPage(DriverManager.getDriver());
        newTodoPage = new NewTodoPage(DriverManager.getDriver());
        faker = new Faker();
        url = FrameworkConstants.getURL();
        herOkuUrl = FrameworkConstants.getHerokuUrl();
        todoUrl = FrameworkConstants.getTodoUrl();
        createNewToDoText = FrameworkConstants.getCreateNewTodo();
        readyToMark = FrameworkConstants.getReadyToMark();
        todoItem = FrameworkConstants.getTodoItem();
        email = RegisterApi.email;
        accessToken = RegisterApi.accessToken;


    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }


}
