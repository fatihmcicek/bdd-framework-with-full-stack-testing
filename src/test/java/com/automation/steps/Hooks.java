package com.automation.steps;

import com.automation.config.DriverConfig;
import com.automation.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Hooks {
    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup(Scenario scenario) {
        log.info("Starting scenario: {}", scenario.getName());
        log.info("Thread ID: {}", Thread.currentThread().getId());
        DriverConfig.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverConfig.getDriver();

        if (scenario.isFailed() && driver != null) {
            log.info("Scenario failed, taking screenshot");
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot-" +
                        scenario.getName().replaceAll("\\s+", "_"));
            } catch (Exception e) {
                log.error("Failed to take screenshot: {}", e.getMessage());
            }
        }

        log.info("Finishing scenario: {}", scenario.getName());
        DriverConfig.quitDriver();
    }
}