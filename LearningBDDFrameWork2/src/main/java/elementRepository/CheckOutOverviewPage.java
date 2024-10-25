package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {

	public CheckOutOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-test='shipping-info-value']")
	private WebElement shippingInformation;
	
	@FindBy(xpath="//div[@data-test='payment-info-value']")
	private WebElement paymentInformation;
	
	@FindBy(xpath="//div[@data-test='total-label']")
	private WebElement totalPrice;
	
	@FindBy(id="finish")
	private WebElement finishButton;

	public WebElement getShippingInformation() {
		return shippingInformation;
	}

	public WebElement getPaymentInformation() {
		return paymentInformation;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getFinishButton() {
		return finishButton;
	}
}
