package extras;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinks {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		List<WebElement> listLinks = driver.findElements(By.tagName("a"));
		for (WebElement link : listLinks) {
			String urlLink = link.getAttribute("href");
			URL url = new URL(urlLink);
			URLConnection urlConn = url.openConnection();
			HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
			httpUrlConn.setConnectTimeout(5000);
			httpUrlConn.connect();
			if (httpUrlConn.getResponseCode() == 200) {
				System.out.println(urlLink + " " + httpUrlConn.getResponseCode());
			} else {
				System.err.println(
						urlLink + " " + httpUrlConn.getResponseMessage() + " " + httpUrlConn.getResponseCode());
			}

			httpUrlConn.disconnect();
		}
	}
}
