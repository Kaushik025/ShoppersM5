package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TshirtPage {
	
public WebDriver driver;
public TshirtPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//a[text()='men tshirt']")
private WebElement tshirtTopLink;

@FindBy(xpath="//span[text()='Levis Mens Regular Fit Tee']/../..//button")
private WebElement levisMensRegularfitproduct_AddToCartButton;

public WebElement getLevisMensRegularfitproduct_AddToCartButton() {
	return levisMensRegularfitproduct_AddToCartButton;
}


public WebElement getTshirtTopLink() {
	return tshirtTopLink;
}

}
