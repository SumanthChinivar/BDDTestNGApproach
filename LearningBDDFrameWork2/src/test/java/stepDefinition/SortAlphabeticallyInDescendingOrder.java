package stepDefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elementRepository.HomePage;
import hook.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilPackage.DriverFactory;
import utilityClasses.WebDriverUtility;

public class SortAlphabeticallyInDescendingOrder extends BaseClass {
	WebDriver driver=DriverFactory.getDriver();
	List<WebElement> list;
	List<String> expectedTitle=new ArrayList<String>();
	@Given("User selects {string} drop down to sort the products in descending order")
	public void user_selects_drop_down_to_sort_the_products_in_descending_order(String visibleText) {
		list= driver.findElements(By.xpath("//div[@class='inventory_item_label']/a/div"));
		for(WebElement ele:list) {
			expectedTitle.add(ele.getText());
		}
		Collections.sort(expectedTitle);
		Collections.reverse(expectedTitle);
		HomePage homePage=new HomePage(driver);
		WebElement sortDropDown = homePage.getSortDropDown();
		WebDriverUtility utility=new WebDriverUtility();
		utility.select(sortDropDown, visibleText);
	}

	@Then("Products should be sorted in descending order of alphabets")
	public void products_should_be_sorted_in_descending_order_of_alphabets() {
		List<WebElement> titlesElement = driver.findElements(By.xpath("//div[@class='inventory_item_label']/a/div"));
		 List<String> actualTitle = new ArrayList<String>();
		 for(WebElement ele:titlesElement) {
			 actualTitle.add(ele.getText());
		 }
		 if(actualTitle.equals(expectedTitle)) {
			 System.out.println("Sorted");
		 }else
			 System.out.println("Not sorted");
	}
}
