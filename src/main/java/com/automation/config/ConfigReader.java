package com.automation.config;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class ConfigReader {
    private static final Properties properties = new Properties();
    private static final String CONFIG_PATH = "src/test/resources/config/config.properties";

    static {
        try (FileInputStream input = new FileInputStream(CONFIG_PATH)) {
            properties.load(input);
        } catch (IOException e) {
            log.error("Error loading config file: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            log.warn("Property '{}' not found in config file", key);
        }
        return value;
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("headless"));
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicit.wait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(getProperty("explicit.wait"));
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(getProperty("page.load.timeout"));
    }

    public static String getTestEmail() {
        return getProperty("test.email");
    }

    public static String getTestPassword() {
        return getProperty("test.password");
    }

    public static String getScreenshotPath() {
        return getProperty("screenshot.path");
    }
}