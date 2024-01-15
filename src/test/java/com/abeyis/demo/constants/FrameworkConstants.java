package com.abeyis.demo.constants;

import com.abeyis.demo.utils.ConfigurationReaderFile;

public class FrameworkConstants {
    private FrameworkConstants() {
    }

    private static final String URL = ConfigurationReaderFile.get("url");
    private static final String TODO_URL=ConfigurationReaderFile.get("todoURL");

    private static final String HEROKU_URL=ConfigurationReaderFile.get("herOkuURL");
    private static final String PASSWORD = ConfigurationReaderFile.get("password");

    private static final String CREATE_NEW_TODO=ConfigurationReaderFile.get("createNewTodo");
    private static final String READY_TO_MARK=ConfigurationReaderFile.get("readyToMark");
    private static final String TODO_ITEM=ConfigurationReaderFile.get("todoItem");
    private static final String BASE_URL_REGISTER=ConfigurationReaderFile.get("baseUrlRegister");



    public static String getURL() {
        return URL;
    }

    public static String getTodoUrl(){
        return TODO_URL;
    }

    public static String getHerokuUrl(){
        return HEROKU_URL;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getCreateNewTodo(){
        return CREATE_NEW_TODO;
    }
    public static String getReadyToMark(){
        return READY_TO_MARK;
    }

    public static String getTodoItem(){
        return TODO_ITEM;
    }

    public static String getBaseUrlRegister(){
        return BASE_URL_REGISTER;
    }
}
