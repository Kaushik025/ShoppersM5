package POMClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@aria-label='Account settings']")
	private WebElement AccountSettingIcon;
	
	
	public WebElement getAccountSettingIcon() {
		return AccountSettingIcon;
	}
	
	@FindBy(xpath="//a[@href='/men' and @id='men']")
	private WebElement menMenuLink;
	
	@FindBy(xpath="//a[text()='T-shirts']")
	private WebElement TshirtPopUpLink;


	public WebElement getMenMenuLink() {
		return menMenuLink;
	}

	public WebElement getTshirtPopUpLink() {
		return TshirtPopUpLink;
	}
	
	@FindBy(xpath="//a[@id='cart']")
	private WebElement addToCartLink;


	public WebElement getAddToCartLink() {
		return addToCartLink;
	}
	
//	public void javaScriptClick(WebDriver driver) {       // declared javaScriptClick() for Account setting icon
//		WebElement ele=driver.findElement(By.xpath("//button[@aria-label='Account setting']"));
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click();", ele);
//	}
	


}
