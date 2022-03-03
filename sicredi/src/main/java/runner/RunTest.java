package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features", 
				 glue = "steps", 
				 tags = "@todos", 
				 plugin = {"html:target/cucumber-reports.html"},
                 monochrome = true,
                 dryRun = false,
                 publish = true
				)
public class RunTest {
	
}
