package com.automation.utils;

import lombok.extern.log4j.Log4j2;

import java.util.Random;

@Log4j2
public class Helper {

    public String generateRandomEmail() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        return "test" + timestamp + "@test.com";
    }

    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }
}