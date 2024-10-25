package hook;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilPackage.DriverFactory;
import utilityClasses.JavaUtility;
import utilityClasses.ThreadUtility;

public class BaseClass {

	WebDriver driver;	
	@BeforeClass
	public void beforeScenario() throws Exception
	{
		DriverFactory.setUpBrowser();
		driver=DriverFactory.getDriver();
	}
	
	@AfterClass
	public void afterScenario(Scenario scenario) throws IOException
	{
		if(scenario.isFailed()) {
			JavaUtility javaUtility=new JavaUtility();
			TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
			File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
			File newFile=new File("./screenShot/"+javaUtility.getCurrentTime()+".png");
			FileHandler.copy(file, newFile);
		}	
		DriverFactory.quitBrowser();
	}
}
