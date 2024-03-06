package CucumberTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Calc", glue = "StepsDef", plugin = {"pretty", "html:target/cucumber-reports/html", "json:target/cucumber-reports/Cucumber.json"})
public class CucumberRunner_Calc {
}
