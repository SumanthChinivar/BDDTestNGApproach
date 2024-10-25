package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutInformationPage {
	public CheckOutInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	private WebElement firstNameTextField;
	
	@FindBy(id="last-name")
	private WebElement lastNameTextField;
	
	@FindBy(id="postal-code")
	private WebElement pinCodeTextField;
	
	@FindBy(id="continue")
	private WebElement continueButton;

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getPinCodeTextField() {
		return pinCodeTextField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
}
