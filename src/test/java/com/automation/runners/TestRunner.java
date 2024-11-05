package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
                "src/test/resources/features/TC06_api_product_list.feature",
                "src/test/resources/features/TC07_api_brands_list.feature",
                "src/test/resources/features/TC08_api_search_product.feature",
                "src/test/resources/features/TC09_api_verify_login.feature",
                "src/test/resources/features/TC10_api_create_account.feature"
        },
        glue = {"com.automation.steps", "com.automation.steps.api"},
        plugin = {
                "pretty",
                "html:test-output/cucumber-reports/cucumber-pretty.html",
                "json:test-output/cucumber-reports/CucumberTestReport.json",
                "rerun:test-output/cucumber-reports/rerun.txt"
        },
        tags = "@api",
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}