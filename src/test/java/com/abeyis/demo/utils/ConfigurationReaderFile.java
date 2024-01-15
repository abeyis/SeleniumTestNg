package com.abeyis.demo.utils;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
           String path = System.getProperty("user.dir")+"/src/test/resources/config/Configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

}
