package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingPage {
	
public WebDriver driver;
	
	
	public AccountSettingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[name()='svg' and @data-testid='LogoutIcon']")// we can use text() also here i.e. //li[text()='Logout']
	private WebElement logoutIcon;


	public WebElement getLogoutIcon() {
		return logoutIcon;
	}
	
	@FindBy(xpath="//li[text()='My Profile']")
	public WebElement myProfileLink;


	public WebElement getMyProfileLink() {
		return myProfileLink;
	}


}
