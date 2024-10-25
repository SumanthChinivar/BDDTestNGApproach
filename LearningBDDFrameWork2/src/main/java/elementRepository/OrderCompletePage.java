package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCompletePage {

	public OrderCompletePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Back Home']")
	private WebElement backButton;
	
	public WebElement getBackButton() {
		return backButton;
	}

	public WebElement getThanksMessage() {
		return thanksMessage;
	}

	@FindBy(xpath = "//h2[contains(text(),'Thank you')]")
	private WebElement thanksMessage;
}
