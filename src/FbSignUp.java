import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignUp {

	public static void main(String[] args) {
		System.setProperty("webdriver,chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement signUpButton = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		signUpButton.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("abc");
		
		WebElement surname = driver.findElement(By.xpath("//input[@name='lastname']"));
		surname.sendKeys("xyz");
		
		WebElement mobileOrEmail = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		mobileOrEmail.sendKeys("1234567890");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password_step_input']"));
		password.sendKeys("Test@123");
		
//		WebElement day = driver.findElement(By.xpath("//select[@id='day']//option[@value=18]"));
//		day.click();
		//OR
		WebElement day = driver.findElement(By.id("day"));
		Select date = new Select(day);
		date.selectByVisibleText("18");
		
//		WebElement month = driver.findElement(By.xpath("//select[@id='month']//option[@value=9]"));
//		month.click();
		//OR
		WebElement month = driver.findElement(By.id("month"));
		Select mon = new Select(month);
		mon.selectByVisibleText("Sep");
		
		List<WebElement> Months = mon.getOptions();

//		for(WebElement elm : Months ) {
//			System.out.println(elm.getText());
//		}
		
		List<WebElement> allMonths = mon.getOptions();

		for(WebElement elm : allMonths ) {
			System.out.println(elm.getText());
		}
//		WebElement year = driver.findElement(By.xpath("//select[@id='year']//option[@value=1997]"));
//		year.click();
		//OR
		WebElement year = driver.findElement(By.id("year"));
		Select yr = new Select(year);
		yr.selectByVisibleText("1997");
		System.out.println(yr.getFirstSelectedOption().getText());
		
		String Gender = "Male";
		
//		WebElement Female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
//		WebElement Male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
//		WebElement Other = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
////		gender.click();
//		
//		if(Gender.equals("Female")) {
//			Female.click();
//		}else if(Gender.equals("Male")) {
//			Male.click();
//		}else {
//			Other.click();
//		}
		//DYNAMIC XPATH
		WebElement gender = driver.findElement(By.xpath("//label[text()='"+Gender+"']/following-sibling::input"));
		gender.click();
	}

}
