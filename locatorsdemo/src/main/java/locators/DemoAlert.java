package locators;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAlert {


	@Test
	public void handleAlert() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdeekonda\\Desktop\\Selenium Jars\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.tsrtc.in/site");
		driver.findElement(By.xpath("//*[@id=\'searchBtn\']")).click();
		
		Thread.sleep(2000);
		//Alert alt= driver.switchTo().alert(); //switchto-alert windw
		//alt.accept();
		
		//othr method
	String actual_msg=	driver.switchTo().alert().getText();
	System.out.println("msg is"+ actual_msg);
	driver.switchTo().alert().accept();
	
		//driver.switchTo().alert().dismiss();
		
		String expected_msg= "Please select start place.";
		Assert.assertEquals(actual_msg, expected_msg);
		driver.quit();
	}
}
