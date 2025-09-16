import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoClass {
	
	 public static void main(String args[]) 
	 {
		 WebDriverManager.chromedriver().setup();
		 
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://demo.uffizio.com/jsp/trakzee_login.jsp");
		 
		 
		 String title = driver.getTitle();
		 System.out.println(title);
		 
		 WebElement usernamefield = driver.findElement(By.xpath("//input[@id='username']"));
		 
		 WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
		 
		
		 
		 usernamefield.sendKeys("regadmin@gmail.com");
		 passwordfield.sendKeys("Auto@1234");
		 
		 WebElement loginbutton = driver.findElement(By.xpath("div[id='tree-module'] span[class='module-img tree-icon icon tree-icon-text tree-Settings 0']"));
		 
		 loginbutton.click();
		 
		 System.out.println(driver.getTitle());
		 
		 
		 WebElement divFrame = driver.findElement(By.xpath("//iframe[@id=\"divframe\"]"));
		 
		 driver.switchTo().frame(divFrame);
		 
		 
	
		 
		
		 
		 
		 
	 }

}
