package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='cart_item']")
	private WebElement cartItem;

	public WebElement getCartItem() {
		return cartItem;
	}
	
	@FindBy(xpath="//button[text()='Checkout']")
	private WebElement checkOutButton;

	public WebElement getCheckOutButton() {
		return checkOutButton;
	}
}
