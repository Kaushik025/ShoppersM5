package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	/**Author : Kaushik 
	 * When we get ElementClickInterceptedException(when element is hidden by other element)
	 * then we will use java script click
	 * @param driver
	 * @param ele
	 */
	
	public void javaScriptClick(WebDriver driver,WebElement ele) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click;", ele);
	}
	/**
	 * to avoid ElementClickInterceptedExcetion
	 * @param driver
	 * @param ele
	 * @param data
	 */
	public void javaScriptSendKeys(WebDriver driver,WebElement ele,String data) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value=argument[1];", ele,data);
	}
	
	/**Author: Kaushik
	 * this method will scroll the webpage till the given element
	 * @param driver
	 * @param ele
	 */
	public void javaScriptScrollTillWebElement(WebDriver driver,WebElement ele) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		
		}
	
	/**Author: Kaushik
	 * this method will scroll the webpage with given coordinates
	 * @param driver
	 * @param xCordinate
	 * @param yCordinate
	 */
	public void javaScriptScrollByCoordinates(WebDriver driver,int xCordinate,int yCordinate) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("scrollBy("+xCordinate+","+yCordinate+");");
	}
	
	/**Author: Kaushik
	 * this method will highlight the WebElement border with 2px red colour
	 * @param driver
	 * @param ele
	 */
	public void javaScriptHighLightWebElement(WebDriver driver,WebElement ele) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.border='2px solid red';",ele);
	}
	/**
	 * this method waits untill given element reaches to clickable state
	 * @param locator
	 * @param driver
	 * @param ele
	 * @param timeDelay
	 */
	public void explicitlyWaitForElementClickable(By locator,WebDriver driver,WebElement ele,int timeDelay) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	/**
	 * this method will wait until alert is present
	 * @param locator
	 * @param driver
	 * @param ele
	 * @param timeDelay
	 */
	public void explicitlyWaitForAlertToBePresent(By locator,WebDriver driver,WebElement ele,int timeDelay) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * this method will wait until particular url is present
	 * @param locator
	 * @param driver
	 * @param ele
	 * @param timeDelay
	 * @param url
	 */
	public void explicitlyWaitForUrlToBePresent(By locator,WebDriver driver,WebElement ele,int timeDelay,String Completeurl) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.urlToBe(Completeurl));
	}
	/**
	 * this method will wait until particular page is displayed/appears
	 * @param locator
	 * @param driver
	 * @param ele
	 * @param timeDelay
	 * @param CompleteTitle
	 */
	public void explicitlyWaitForTitle(By locator,WebDriver driver,WebElement ele,int timeDelay,String CompleteTitle) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.titleIs(CompleteTitle));
	}
	 /**
	  * this method will wait until the given element is visible
	  * @param locator
	  * @param driver
	  * @param ele
	  * @param timeDelay
	  */
	public void explicitlyWaitForVisibilityOfElement(By locator,WebDriver driver,WebElement ele,int timeDelay) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void mouseOverAction(WebDriver driver,WebElement ele) {
		Actions action=new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
	public void doubleClickAction(WebDriver driver,WebElement ele) {
		Actions action=new Actions(driver);
		action.doubleClick(ele).perform();
	}
	
	public void rightClickAction(WebDriver driver,WebElement ele) {
		Actions action=new Actions(driver);
		action.contextClick().perform();
		
	}
	/**
	 * To perform drag and drop operation between two elements
	 * @param driver
	 * @param draggingElement
	 * @param droppingElement
	 */
	public void dragAndDropAction(WebDriver driver,WebElement draggingElement,WebElement droppingElement) {
		Actions action=new Actions(driver);
		action.dragAndDrop(draggingElement, droppingElement).perform();
		
	}
	public void clickAndHold(WebDriver driver,WebElement ele) {
		Actions action=new Actions(driver);
		action.clickAndHold(ele).perform();
	}
	/**
	 * To perform scrolling of webpage till the webelement
	 * @param driver
	 * @param ele
	 */
	public void scrollToWebElementByActionClass(WebDriver driver,WebElement ele) {
		Actions action=new Actions(driver);
		action.scrollToElement(ele).perform();
	}


}
