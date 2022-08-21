import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver,chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		// Step1. Click  on the Login Link
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		
		//Step2: Enter Username
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");
		
		
		//Step3: Enter Password
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Test@1234");
		
		//Step4: Click Remember me
		WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
		//Step5: Click on Login Button
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();
		
		//Step6. Validate the error message
		WebElement error = driver.findElement(By.id("msg_box"));
		
		String actError = error.getText();
		String expError = "The email or password you have entered is invalid.";
		
		if(actError.equals(expError)){
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links are: "+ Links.size() );
		
		for(int i=0;i<Links.size();i++) {
			System.out.println(Links.get(i).getAttribute("href"));
		}
		//Step7. Close browser
		driver.close();
		
	}

}
