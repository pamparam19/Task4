package org.example.framework.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"org/example/framework/steps"},
        features = {"src/test/resources/features"},
        tags = {"@firstTest"}
)
public class CucumberRunner {
}
