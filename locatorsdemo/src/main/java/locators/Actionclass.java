package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionclass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdeekonda\\Desktop\\Selenium Jars\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//contextclick- right click 
		
		/*driver.get("https://swisnl.github.io/jquery-contextMenu/demo.html");
		Actions act= new Actions(driver);
	//	act.click().build().perform();
		act.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Copy']")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
	    driver.quit();	
	    */
	    ////double click
	    driver.get("//https://api.jquery.com/dblclick/");
	    //driver.switchTo().frame(0); //or
	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
	    
	    Actions act= new Actions(driver);
	    act.doubleClick(driver.findElement(By.xpath("//span[text()='Double click the block']//parent::body/div"))).perform();
	    		//+ "/html/body/span"
	    
	    
	}

}
