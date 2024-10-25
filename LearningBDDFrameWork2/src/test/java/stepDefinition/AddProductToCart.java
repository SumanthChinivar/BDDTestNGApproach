package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import hook.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.ThreadUtility;

public class AddProductToCart extends BaseClass{
	WebDriver driver=DriverFactory.getDriver();
	HomePage homePage=new HomePage(driver);
	
	@Given("User is logged in with {string} and {string}")
	public void user_is_logged_in_with_and(String userName, String password) {
	    LoginPage loginPage=new LoginPage(driver);
	    loginPage.login(userName, password);
	}

	@When("User clicks on {string} add to cart button")
	public void user_clicks_on_add_to_cart_button(String productName) {
	    driver.findElement(By.xpath("//div[text()='"+productName+"']/../../..//button")).click();
	}
	
	@Then("{string} product is added to cart")
	public void product_is_added_to_cart(String productName) throws InterruptedException {
		homePage.getCartIcon().click();
		Thread.sleep(5000);
		 WebElement element = driver.findElement(By.xpath("//div[text()='"+productName+"']"));
		 Assert.assertTrue(!element.isDisplayed(),"Product is not added to cart");
	
	}

}
