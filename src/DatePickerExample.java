import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver,chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement dob = driver.findElement(By.id("dob"));
		dob.click();
		
		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select ddYear = new Select(year);
		ddYear.selectByVisibleText("1997");
		
		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select ddMonth = new Select(month);
		ddMonth.selectByVisibleText("Sep");
		
		WebElement Date = driver.findElement(By.xpath("//a[@data-date='18']"));	
		Date.click();
	}

}
