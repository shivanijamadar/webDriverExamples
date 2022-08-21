import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		System.setProperty("webdriver,chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		
		System.out.println("Total rows are: "+rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]//th"));
		
		System.out.println("Total columns are: "+columns.size());
		for(WebElement tableRow:rows) {
			List<WebElement> cells = tableRow.findElements(By.tagName("td"));
			for(WebElement cell:cells) {
				System.out.print(cell.getText()+"\t");
			}
		}
		
		for(int row=1;row<=rows.size();row++) {
			for(int col=1;col<=columns.size();col++) {
				WebElement cell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + row + "]/*[" + col + "]"));
				System.out.print(cell.getText() + "\t");
			}
			System.out.println();
		}
		
		String Company = "Magazzini Alimentari Riuniti";
        
        String Xpath = "//td[text()='" + Company + "']/following-sibling::td[2]";
        WebElement Country = driver.findElement(By.xpath(Xpath));
        System.out.println("The country is " + Country.getText());
        
//		WebElement data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]//td[1]"));
//		System.out.println("Required data is: "+data.getText());

	}

}
