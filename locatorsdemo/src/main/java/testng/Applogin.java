package testng;

import java.util.concurrent.TimeUnit;

//do not use junit - use annotations 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Applogin {

	//dependecies b/w testcases
	
	
	///for an appl
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser()
	{
		driver = new ChromeDriver();
		System.out.println("browser started");
	}
	
	@Test
	public void startApp()
	{
		Assert.assertEquals(12, 13); //test case fails
		
		System.out.println("start of appl");  //url maybe
		
		//driver = new ChromeDriver();
		driver.get(":8888"); //url 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("/signin"));
		System.out.println("appl loaded");
	}
	
	@Test(dependsOnMethods = "startApp" )  //depends on url, if unable to get it fails
	public void loginApp()
	{
		System.out.println("login to appl");   ///can write actual selenium login code
		
		driver.findElement(By.xpath("username"));
		driver.findElement(By.xpath(".//*[@id='txtpassword']")).sendKeys("");
		driver.findElement(By.xpath("loginbtn"));
				
		//to check whethr landed on corct page- chk with any menu item
		boolean status= driver.findElement(By.xpath("/homepage")).isDisplayed();
		Assert.assertTrue(status);  //loged in sucess
		System.out.println("login sucessful");
		
		
	}
	
	@Test(dependsOnMethods = "loginApp")  //if no login, how can logout be
	//@Test(dependsOnMethods = "{loginApp, startApp}") //multiple depncy
	public void logoutApp() throws InterruptedException
	{
		//profile photo -dropdown to logout
		driver.findElement(By.xpath("click on img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click(); //text that contains and matches logout
		System.out.println("logout of app");
		
		//logout sucees
		Assert.assertTrue(driver.findElement(By.xpath("signup page-username tab ")).isDisplayed());
		System.out.println("logout sucesful");
		
		//driver.quit(); //other way
	}
	
	@AfterClass
   public void closeApp()
   {
	   driver.quit();
	   System.out.println("browser closed");
   }
	
	
}

//asert is mandatory in evry test or els its useless- act as validatn 

