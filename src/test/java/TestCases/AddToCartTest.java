package TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMClass.AccountSettingPage;
import POMClass.AddressFormPage;
import POMClass.HomePage;
import POMClass.MyAddress;
import POMClass.MyProfilePage;
import POMClass.NetBankingPage;
import POMClass.OrderConfirm;
import POMClass.PaymentMethod;
import POMClass.TshirtPage;
import POMClass.addToCartPage;
import POMClass.addressPage;
import Utilities.BaseClass;
import Utilities.DataUtility;
@Listeners(Utilities.ListenersUtility.class)
public class AddToCartTest extends BaseClass {
	
	@Test(dataProvider="dataProviderAddress1")
	public void Tc_AddAddress_001_Test(String name, String House_Office, String street, String Landmark, String Country, String state, String City,
			String Pin_code, String Phone_Number) throws Throwable {
		System.out.println("add address");
		Thread.sleep(3000);
		HomePage hp=new HomePage(driver);
		hp.getAccountSettingIcon().click();
		//hp.javaScriptClick(driver);//when getAccountSettingIcon().click() won't work then use javaScriptClick(driver) and call it from homepage,
//		also if we use javaScriptClick() then getAccountSettingIcon().click() should be removed
		
		AccountSettingPage as=new AccountSettingPage(driver);
		as.getMyProfileLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/my-profile/my-profile-info");
		System.out.println("The profile page is opened");
		MyProfilePage mp=new MyProfilePage(driver);
		mp.getMyAddressLink().click();
		
		MyAddress ma=new MyAddress(driver);
		ma.getAddressFormButton().click();
		
		AddressFormPage afp=new AddressFormPage(driver);
		afp.getNameTextField().sendKeys(name);
		afp.getHouseOfficeInformationTextField().sendKeys(House_Office);
		afp.getStreetInformationTextField().sendKeys(street);
		afp.getLandmarkTextField().sendKeys(Landmark);
		afp.getCountryDropDown().sendKeys(Country);
		WebElement CountryDropDown=afp.getCountryDropDown();
		drpU.selectDropdownByText(Country, CountryDropDown);
		WebElement StateDropDown=afp.getStateDropDown();
		drpU.selectDropdownByText(state, StateDropDown);
		WebElement CityDropDown=afp.getCityDropDown();
		drpU.selectDropdownByText(City, CityDropDown);
		afp.getPincodeTextField().sendKeys(Pin_code);
		afp.getPhoneNumberTextField().sendKeys(Phone_Number);
		afp.getAddAddressButton().click();
		
//		Assert.assertEquals(ma.getaddedAddress().getText(),name);
//		System.out.println("The address -"+name+" is added successfully");

		
	}
	
	@DataProvider
	public Object[][] dataProviderAddress1() throws Throwable {
		return data.accessAllAddress();	}
	
//	@DataProvider
//	public Object[][] dataProviderAddress()
//	{
//		Object[][] ref= new Object[1][9];
//		ref[0][0]="LoveBirds";
//		ref[0][1]="Ambani House, 2nd Floor";
//		ref[0][2]="Ambani Street";
//		ref[0][3]="Ambani Point";
//		ref[0][4]="India";
//		ref[0][5]="Karnataka";
//		ref[0][6]="Bengaluru";
//		ref[0][7]="560010";
//		ref[0][8]="9987569010";
//		
//		return ref;
//	}
	
	@Test(dependsOnMethods="Tc_AddAddress_001_Test")
	public void TC_AddToCart_001_Test() throws Throwable {
		Thread.sleep(5000);
		System.out.println("First test case");
		String titleHomePage=driver.getTitle();
		Assert.assertEquals(titleHomePage, "ShoppersStack | Home");
		
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		WebElement menLink=hp.getMenMenuLink();
		
		WU.mouseOverAction(driver, menLink);
		hp.getTshirtPopUpLink().click();
		
		TshirtPage tsp=new TshirtPage(driver);
		String currenturl=driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://www.shoppersstack.com/sub-category/men-tshirt");
		WU.mouseOverAction(driver, tsp.getTshirtTopLink());
		
		tsp.getLevisMensRegularfitproduct_AddToCartButton().click();
		hp.getAddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/cart");
		System.out.println("The cart page has opened");
		
		addToCartPage ac=new addToCartPage(driver);
		String levisProductTest=ac.getlevisProduct().getText();
		Assert.assertEquals(levisProductTest, "Levis Mens Regular Fit Tee");
		System.out.println("The Product is added to the cart");
		ac.getbuyNowButtonInAddToCartPage().click();
		String addressPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(addressPageUrl, "https://www.shoppersstack.com/selectaddress");
		System.out.println("The address page is displayed");
		
		addressPage ap= new addressPage(driver);
		ap.getLovebirdAddress().click();
		ap.getProceedButton().click();
		
		PaymentMethod pm= new PaymentMethod(driver);
		pm.getCashOnDelivery().click();
		pm.getProceedButton().click();
		
		OrderConfirm oc= new OrderConfirm(driver);
		
		Assert.assertEquals(oc.getOrderConfirmed().getText(),"Order Confirmed");
		System.out.println("The order got confirmed in cash on delivery");
		
	
		}
	
	@Test(priority = 1, dependsOnMethods ="Tc_AddAddress_001_Test")
	public void EndToEndNetBanking() throws Throwable {
		
		Thread.sleep(5000);
		System.out.println("First test case");
		String titleHomePage=driver.getTitle();
		Assert.assertEquals(titleHomePage, "ShoppersStack | Home");
		
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		WebElement menLink=hp.getMenMenuLink();
		
		WU.mouseOverAction(driver, menLink);
		hp.getTshirtPopUpLink().click();
		
		TshirtPage tsp=new TshirtPage(driver);
		String currenturl=driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://www.shoppersstack.com/sub-category/men-tshirt");
		WU.mouseOverAction(driver, tsp.getTshirtTopLink());
		
		tsp.getLevisMensRegularfitproduct_AddToCartButton().click();
		hp.getAddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/cart");
		System.out.println("The cart page has opened");
		
		addToCartPage ac=new addToCartPage(driver);
		String levisProductTest=ac.getlevisProduct().getText();
		Assert.assertEquals(levisProductTest, "Levis Mens Regular Fit Tee");
		System.out.println("The Product is added to the cart");
		ac.getbuyNowButtonInAddToCartPage().click();
		String addressPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(addressPageUrl, "https://www.shoppersstack.com/selectaddress");
		System.out.println("The address page is displayed");
		
		addressPage ap= new addressPage(driver);
		ap.getLovebirdAddress().click();
		ap.getProceedButton().click();
		
		PaymentMethod pm= new PaymentMethod(driver);
		Thread.sleep(3000);
		pm.getNetBankingButton().click();
		pm.getProceedButton().click();
			
		NetBankingPage nb= new NetBankingPage(driver);
		driver.switchTo().frame(nb.getNetBankingFrameTag());
		
		nb.getIDHC_radioButton().click();
		nb.getSubmitButton().click();
	}
	
//@Test	
//public void TC_AddToCart_002_Test() throws Throwable {
//	
//		
//		System.out.println("Second test case");
//		
//				
//	}
		

}
