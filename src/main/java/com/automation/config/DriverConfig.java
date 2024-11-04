package com.automation.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

@Log4j2
public class DriverConfig {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            initializeDriver();
        }
        return driverThreadLocal.get();
    }

    public static void initializeDriver() {
        WebDriver driver = createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getPageLoadTimeout()));
        driverThreadLocal.set(driver);
    }

    private static WebDriver createDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();
        boolean isHeadless = ConfigReader.isHeadless();

        return switch (browser) {
            case "chrome" -> createChromeDriver(isHeadless);
            case "firefox" -> createFirefoxDriver(isHeadless);
            case "edge" -> createEdgeDriver(isHeadless);
            default -> {
                log.warn("Invalid browser specified. Defaulting to Chrome");
                yield createChromeDriver(isHeadless);
            }
        };
    }

    private static WebDriver createChromeDriver(boolean isHeadless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean isHeadless) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean isHeadless) {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new EdgeDriver(options);
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}