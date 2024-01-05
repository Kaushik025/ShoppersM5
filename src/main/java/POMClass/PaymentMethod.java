package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethod {
public WebDriver driver;
	
	
	public PaymentMethod(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Cash On Delivery (COD)']/preceding-sibling::span/input")
	private WebElement cashOnDeliveryRadioButton;


	public WebElement getCashOnDelivery() {
		return cashOnDeliveryRadioButton;
	}
	
	@FindBy(xpath="//button[text()='Proceed']")
	private WebElement proceedButton;


	public WebElement getProceedButton() {
		return proceedButton;
	}
	
	@FindBy(xpath="input[@value='Net Banking']")
	private WebElement NetBankingButton;


	public WebElement getNetBankingButton() {
		return NetBankingButton;
	}

}
