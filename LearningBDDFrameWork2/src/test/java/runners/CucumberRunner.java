package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"stepDefinition"},
features= {"./src/test/resources/featureFiles"},
plugin={"rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CucumberRunner extends AbstractTestNGCucumberTests{
//	@Override
//	@DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
	
	@DataProvider(name = "scenarios", parallel = true)
    public Object[][] scenarios() {
        System.setProperty("dataproviderthreadcount", "3"); // Set thread count here
        return super.scenarios();
    }
}
