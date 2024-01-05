package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMClass.AccountSettingPage;
import POMClass.HomePage;
import POMClass.LoginPage;
import POMClass.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	public DataUtility data= new DataUtility();
	public WebDriverUtility WU=new WebDriverUtility();
	public DropDownUtility drpU=new DropDownUtility();
	
	
	@BeforeClass
	public void launchingBrowser() throws Throwable {
		System.out.println("------------LaunchingBrowser-----------------");
		String BROWSER=data.dataFromPropertiesFile("browser");
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
			
			
			}
		
		else {
			driver=new ChromeDriver();
			
		}
		String URL=data.dataFromPropertiesFile("url");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	@BeforeMethod
	public void loginToApplication() throws Throwable {
		System.out.println("-------------LoginToApplication------------------");
		
		Thread.sleep(3000);	
		WelcomePage WLpage=new WelcomePage(driver);
		WLpage.getMainLoginButton().click();
		
		LoginPage Lpage=new LoginPage(driver);
		
		String emailId=data.dataFromPropertiesFile("email");
		Lpage.getEmailTextField().sendKeys(emailId);
		
		String Password=data.dataFromPropertiesFile("password");
		Lpage.getPasswordTextField().sendKeys(Password);
		
		Lpage.getLoginButton().click();
		
	}
	@AfterMethod
	public void logoutFromApplication() throws Throwable {
		System.out.println("---------------LogotFromApplication----------------");
		
		Thread.sleep(5000);
		HomePage Hpage=new HomePage(driver);
		Thread.sleep(3000);
		Hpage.getAccountSettingIcon().click();
		WU.javaScriptClick(driver,Hpage.getAccountSettingIcon());
		
		AccountSettingPage ASpage=new AccountSettingPage(driver);
		Thread.sleep(3000);
		ASpage.getLogoutIcon().click();
		
	}
	@AfterClass
	public void quitBrowser() {
		System.out.println("----------------quitBrowser------------------------");
		driver.quit();
		
	}
}
