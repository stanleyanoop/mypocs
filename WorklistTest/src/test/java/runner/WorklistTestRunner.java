package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
       features = {"src/test/resources/features/"},
       glue = "stepdefs",
       tags = "@dev",
       plugin = {"pretty", "html:target/reports/cucumber-reports.html", "json:target/reports/cucumber.json"}
)
public class WorklistTestRunner {

}
