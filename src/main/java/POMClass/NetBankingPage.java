package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetBankingPage {
	
public WebDriver driver;
	
	
	public NetBankingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getNetBankingFrameTag() {
		return netBankingFrameTag;
	}

	@FindBy(xpath="//iframe[@title='Netbanking']")
	private WebElement netBankingFrameTag;
	
	@FindBy(xpath="//input[@value='IDHC']")
	private WebElement IDHC_radioButton;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;


	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getIDHC_radioButton() {
		return IDHC_radioButton;
	}
	
}

