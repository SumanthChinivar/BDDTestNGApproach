package stepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.MenuPage;
import hook.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.FileUtility;
import utilityClasses.ThreadUtility;

public class LoginLogout extends BaseClass{
	WebDriver driver=DriverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage=new HomePage(driver);

	@Given("Browser is launched and url is navigated")
	public void browser_is_launched_and_url_is_navigated() throws Exception {
		FileUtility fileUtility = new FileUtility();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = fileUtility.getDataFromPropertiesFiles("url");
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
		loginPage.getUserNameTextField().sendKeys(username);
		loginPage.getPasswordTextField().sendKeys(password);
	}

	@When("Clicks on login button")
	public void clicks_on_login_button() {
		loginPage.getLoginButton().click();
	}

	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
		WebElement swagLabHeader=homePage.getSwagLabHeader();
		Assert.assertTrue(swagLabHeader.isDisplayed());
	}

	@Then("User clicks on menu button and clicks on logout")
	public void user_clicks_on_menu_button_and_clicks_on_logout() {
		homePage.getMenuButton().click();
		MenuPage menuPage=new MenuPage(driver);
		menuPage.getLogoutLink().click();
	}

	@Then("User should be logged out")
	public void user_should_be_logged_out() {
		WebElement loginButton = loginPage.getLoginButton();
		Assert.assertTrue(loginButton.isDisplayed());
	}
}
