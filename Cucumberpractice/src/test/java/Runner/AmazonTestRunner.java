package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/Appfeature"},
		glue= {"Stepdefinition"},
		plugin = {"pretty"})
		
public class AmazonTestRunner {


}
