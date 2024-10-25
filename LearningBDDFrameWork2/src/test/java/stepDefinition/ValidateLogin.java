package stepDefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.MenuPage;
import hook.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilPackage.DriverFactory;

public class ValidateLogin extends BaseClass{
	WebDriver driver=DriverFactory.getDriver();
	LoginPage loginPage=new LoginPage(driver);
	HomePage homePage=new HomePage(driver);
	
	@Given("User enters valid username and password")
	public void user_enters_valid_username_and_password(DataTable dataTable) {
		List<List<String>> list=dataTable.asLists();
		loginPage.getUserNameTextField().sendKeys(list.get(0).get(0));
		System.out.println(list.get(0).get(0));
		loginPage.getPasswordTextField().sendKeys(list.get(0).get(1));
		System.out.println(list.get(0).get(1));
	}
	
	@Then("Homepage is displayed")
	public void homepage_is_displayed() {
	    WebElement swagLabHeader = homePage.getSwagLabHeader();
	    Assert.assertTrue(swagLabHeader.isDisplayed());
	}

	@Then("User is logged out")
	public void user_is_logged_out() {
	    homePage.getMenuButton().click();
	    MenuPage menuPage=new MenuPage(driver);
	    menuPage.getLogoutLink().click();
	    WebElement loginButton = loginPage.getLoginButton();
	    Assert.assertTrue(loginButton.isDisplayed());
	}
}
