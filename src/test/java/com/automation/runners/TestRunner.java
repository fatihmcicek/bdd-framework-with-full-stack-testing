package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.steps",
        plugin = {
                "pretty",
                "html:test-output/cucumber-reports/cucumber-pretty.html",
                "json:test-output/cucumber-reports/CucumberTestReport.json",
                "rerun:test-output/cucumber-reports/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@smoke or @regression",
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}