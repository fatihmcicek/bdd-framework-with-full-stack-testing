package com.automation.utils;

import lombok.extern.log4j.Log4j2;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public String getTestFilePath(String fileName) {
        return Paths.get("src/test/resources/testdatas/contact_us.txt", fileName)
                .toAbsolutePath()
                .toString();
    }

    public boolean isFileExists(String fileName) {
        return Files.exists(Paths.get(getTestFilePath(fileName)));
    }

    public String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("+1"); // US format
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    public static String getCurrentDateAsString() {
        return java.time.LocalDate.now().toString();
    }
}