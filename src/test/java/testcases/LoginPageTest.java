package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import testdata.DataSupplier;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();

		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void navToLoginTest() {
		loginPage.navToLogin();
	}
	
	@DataProvider
	public Object[][] excelData() {
		Object data[][] = DataSupplier.getData("login");
		
		return data;
	}

	@Test(priority = 2, dataProvider = "excelData")
	public void loginTest(String uname, String pwd) {
		loginPage.login(uname, pwd);
	}

	@Test(priority = 3)
	public void verifyLoginTest() {
		loginPage.verifyLogin();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}