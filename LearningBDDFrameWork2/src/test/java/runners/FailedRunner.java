package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"stepDefinition","hook"},
features= {"./src/test/resources/featureFiles","@target/failed.txt"},
plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class FailedRunner extends AbstractTestNGCucumberTests{

}
