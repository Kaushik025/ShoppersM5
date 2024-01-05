package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {
	
	public void selectDropdownByText(String textOfOption,WebElement selectTagOfDropDown) {
		Select select=new Select(selectTagOfDropDown);
		select.selectByVisibleText(textOfOption);
	}
	public void selectDropdownByValueOfValueAttribute(WebElement selectTagOfDropDown,String valueAttributevalue) {
		Select select=new Select(selectTagOfDropDown);
		select.selectByValue(valueAttributevalue);
	}
	
	public void selectDropdownByIndex(int index,WebElement selectTagDropDown) {
		Select select=new Select(selectTagDropDown);
		select.selectByIndex(index);
	}
	
	public void deselectDropdownByText(String textOfOption,WebElement selectTagOfDropDown) {
		Select select=new Select(selectTagOfDropDown);
		select.deselectByVisibleText(textOfOption);
	}
	
	public void deselectDropdownByValueOfValueAttribute(WebElement selectTagOfDropDown,String valueAttributevalue) {
		Select select=new Select(selectTagOfDropDown);
		select.deselectByValue(valueAttributevalue);
	}
	

	public void deselectDropdownByIndex(int index,WebElement selectTagOfDropDown) {
		Select select=new Select(selectTagOfDropDown);
		select.deselectByIndex(index);
	}
	
	public ArrayList dropdown(WebElement selectTagOfDropDown) {
		Select select=new Select(selectTagOfDropDown);
		List<WebElement> allOptions = select.getOptions();
		
		ArrayList<String> allOptionsTexts = new ArrayList<String>();
		for(WebElement ele:allOptions) {
			allOptionsTexts.add(ele.getText());
		}
		return allOptionsTexts;
	}
	
	public WebElement ToGetParticularOptionOnIndex(WebElement selectTagOfDropDown,int indexOfOption) {
		Select select=new Select(selectTagOfDropDown);
		List<WebElement> allOptions = select.getOptions();
		WebElement particularOptionWebElement=allOptions.get(indexOfOption);
		return particularOptionWebElement;
	}

}
