package com.abeyis.demo.apis.payloads;

public class Payloads {
    public static String registerPayload
            (
                    String email,
                    String password,
                    String firstName,
                    String lastName
            ) {
        return "{\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\"\n" +
                "}";
    }
    public static String taskPayload(){
        return "{\n" +
                "    \"item\": \"Learn\",\n" +
                "    \"isCompleted\": false\n" +
                "}";
    }
}
