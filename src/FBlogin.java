import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBlogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver,chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		//Step1: Enter Username
//		WebElement UserName = driver.findElement(By.xpath("//input[@id='email']"));
//OR
		WebElement UserName = driver.findElement(By.cssSelector("input#email"));
		UserName.sendKeys("abc@xyz.com");
		
		
		//Step2: Enter Password
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys("Test@1234");
		
		
		//Step3: Click login
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
		loginButton.click();
		
		//driver.close();
	}

}
