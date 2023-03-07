package extras;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class notificationAllow {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		
		contentSettings.put("notifications", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
	}
}
