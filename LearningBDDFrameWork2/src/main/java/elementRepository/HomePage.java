package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Swag Labs' and @class='app_logo']")
	private WebElement swagLabHeader;

	public WebElement getSwagLabHeader() {
		return swagLabHeader;
	}
	
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement menuButton;

	public WebElement getMenuButton() {
		return menuButton;
	}
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement cartIcon;

	public WebElement getCartIcon() {
		return cartIcon;
	}
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement sortDropDown;

	public WebElement getSortDropDown() {
		return sortDropDown;
	}
}
