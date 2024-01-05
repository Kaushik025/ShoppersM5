package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirm {
public WebDriver driver;
	
	
	public OrderConfirm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Order Confirmed']")
	private WebElement orderConfirmed;


	public WebElement getOrderConfirmed() {
		return orderConfirmed;
	}

}
