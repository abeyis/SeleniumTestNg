package com.abeyis.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ConfigurationReaderFile {

    private ConfigurationReaderFile() {
    }

    private static final Properties properties;

    static {
        FileInputStream input=null;
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/config/Configuration.properties";
            input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String keyName) {
        String value = properties.getProperty(keyName);
        if (Objects.isNull(value)) {
            try {
                throw new Exception("Property name " + keyName + "is not found. Please check config.properties");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }

}
