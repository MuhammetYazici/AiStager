package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature",
        tags = "@Smoke",
        glue = {"StepDefinations", "Hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"})

public class Smoke extends AbstractTestNGCucumberTests {
}
