package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import testutils.TestUtil;

public class LoginPage extends TestBase {
	private static final Logger logger = LogManager.getLogger();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.ExplicitWait));

	@FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
	WebElement signInBtn;

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(id = "send2")
	WebElement loginBtn;

	@FindBy(xpath = "//span[@class='logged-in']")
	WebElement welcomeMsg;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void navToLogin() {
		logger.info("navigating to login page");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[contains(text(),'Sign In')])[1]")));
		if (signInBtn.isDisplayed()) {
			signInBtn.click();
		}
	}

	public void login(String uname, String pwd) {
		logger.info("filling login credentials and clicking the button");
		emailId.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
	}

	public void verifyLogin() {
		logger.info("verifying the login");
		if (welcomeMsg.isDisplayed()) {
			System.out.println("Logged in successfully");
		}
	}
}