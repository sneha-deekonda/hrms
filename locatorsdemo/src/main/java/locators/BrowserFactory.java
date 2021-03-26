package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdeekonda\\Desktop\\Selenium Jars\\chromedriver.exe");
			driver= new ChromeDriver();
		//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sdeekonda\\Desktop\\Selenium Jars\\firefoxdriver.exe");
		   driver= new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\sdeekonda\\Desktop\\Selenium Jars\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("we do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //comn for all broswer
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //if elmnts are loading slowly
	
		return driver;
	}

	
	public static void quitBrowser(WebDriver driver) //only close respctive browser
	{
		driver.quit();
	}
}
