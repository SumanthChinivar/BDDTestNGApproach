package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import elementRepository.CartPage;
import elementRepository.CheckOutInformationPage;
import elementRepository.CheckOutOverviewPage;
import elementRepository.HomePage;
import elementRepository.OrderCompletePage;
import hook.BaseClass;
import io.cucumber.java.en.Then;
import utilPackage.DriverFactory;
import utilityClasses.ThreadUtility;

public class BuyProduct extends BaseClass{
	WebDriver driver=DriverFactory.getDriver();
	CheckOutInformationPage checkOutInformationPage=new CheckOutInformationPage(driver);
	OrderCompletePage completePage=new OrderCompletePage(driver);
	CheckOutOverviewPage checkOutOverviewPage=new CheckOutOverviewPage(driver);
	
	@Then("{string} Add to cart button should be turned into remove button")
	public void add_to_cart_button_should_be_turned_into_remove_button(String productName) {
	    WebElement removeButton = driver.findElement(By.xpath("//div[text()='"+productName+"']/../../..//button[text()='Remove']"));
	    Assert.assertTrue(removeButton.isDisplayed(),"Add to cart did not change to remove button");
	}

	@Then("Navigate to cart page")
	public void navigate_to_cart_page() {
	   HomePage homePage=new HomePage(driver);
	   homePage.getCartIcon().click();
	}

	@Then("{string} should be added to the cart")
	public void should_be_added_to_the_cart(String productName) {
	   WebElement productTitle = driver.findElement(By.xpath("//div[text()='"+productName+"']"));
	   Assert.assertTrue(productTitle.isDisplayed(),"Product is not added to cart");
	}

	@Then("User clicks on ckeck out button")
	public void user_clicks_on_ckeck_out_button() {
	    CartPage cartPage=new CartPage(driver);
	    cartPage.getCheckOutButton().click();
	}

	@Then("User enters {string},{string} and {string}")
	public void user_enters_and(String firstName, String lastName, String pinCode) {
	    checkOutInformationPage.getFirstNameTextField().sendKeys(firstName);
	    checkOutInformationPage.getLastNameTextField().sendKeys(lastName);
	    checkOutInformationPage.getPinCodeTextField().sendKeys(pinCode);
	}

	@Then("Clicks on continue")
	public void clicks_on_continue() {
		checkOutInformationPage.getContinueButton().click();
	}

	@Then("{string} should be displayed in check out page")
	public void should_be_displayed_in_check_out_page(String productName) {
	    WebElement productTitle = driver.findElement(By.xpath("//div[text()='"+productName+"']"));
	    Assert.assertTrue(productTitle.isDisplayed(),"Product is not added to cart");
	}

	@Then("Display payment id, shipping information and price total")
	public void display_payment_id_shipping_information_and_price_total() {
		
		Reporter.log(checkOutOverviewPage.getPaymentInformation().getText());
		Reporter.log(checkOutOverviewPage.getShippingInformation().getText());
		Reporter.log(checkOutOverviewPage.getPaymentInformation().getText());
	}

	@Then("Click on finish")
	public void click_on_finish() {
	    checkOutOverviewPage.getFinishButton().click();
	}

	@Then("Verify {string} has been displayed")
	public void verify_has_been_displayed(String message) {
	    String text=completePage.getThanksMessage().getText();
	    Assert.assertTrue(text.equals(message),"Message is not displayed");
	}

	@Then("Click on back home button")
	public void click_on_back_home_button() {
	    completePage.getBackButton().click();
	}
}
