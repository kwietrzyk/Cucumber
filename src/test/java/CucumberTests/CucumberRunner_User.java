package CucumberTests;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@User", glue = "StepsDef", plugin = {"pretty", "html:target/cucumber-reports/html", "json:target/cucumber-reports/Cucumber.json"})
public class CucumberRunner_User {
}
