package extras;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectDate {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();

		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("ui-datepicker-div")));
		String monYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String month = monYear.split(" ")[0].trim();
		String year = monYear.split(" ")[1].trim();
		while (!(month.equals("June") && year.equals("2025"))) {
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			monYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			System.out.println(monYear);
			month = monYear.split(" ")[0].trim();
			year = monYear.split(" ")[1].trim();
		}
		driver.findElement(By.xpath("//a[contains(text(),'26')]")).click();
	}
}