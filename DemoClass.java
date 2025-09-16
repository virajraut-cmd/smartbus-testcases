import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoClass {
	
	 public static void main(String args[]) throws InterruptedException
	 {
		 WebDriverManager.chromedriver().setup();
		 
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://demo.uffizio.com/jsp/trakzee_login.jsp");
		 
		 
		 String title = driver.getTitle();
		 System.out.println(title);
		 
		 WebElement usernamefield = driver.findElement(By.xpath("//input[@id='username']"));
		 
		 WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
		 
		 Thread.sleep(1000);
		 
		 usernamefield.sendKeys("regadmin@gmail.com");
		 passwordfield.sendKeys("Auto@1234");
		 
		 WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		 
		 loginbutton.click();
		 
		 System.out.println(driver.getTitle());
		 
		 
		 WebElement divFrame = driver.findElement(By.id("divframe"));
		 
		 driver.switchTo().frame(divFrame);
		 
		 
		 
		 
		 WebElement settingButton = driver.findElement(By.xpath("//div[@id='tree-module']//span[@class='module-img tree-icon icon tree-icon-text tree-Settings 0']"));
		 
		 settingButton.click();
		 
		 WebElement generalTab = driver.findElement(By.xpath("//div[@id='tree-module']//li//span[@title='General'][normalize-space()='General']"));
		 
		 generalTab.click();
		 
		 WebElement objectTab = driver.findElement(By.xpath("//ul[@class='scrollable-content']//li[@title='Object-Renamed']//a[@href='#']//span[@class='nav-text ng-binding'][normalize-space()='Object-Renamed']"));
		 
		 objectTab.click();
		 

		 driver.switchTo().defaultContent();
		 
		 driver.switchTo().frame()
		  
		 
		 
		 Thread.sleep(2000);
		 
		 
//		
		 
		 driver.quit();
		 
		 
		 
	 }

}
