package TestNG_POM_DDF;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KiteLoginTestNG {

	WebDriver driver;
	Sheet sh;
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	KiteHomePage home;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("E:\\Velo\\Sept20.xlsx");
		sh = WorkbookFactory.create(file).getSheet("DDF");

		System.setProperty("webdriver.chrome.driver","E:\\Velo\\sel\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		login1 = new KiteLogin1Page(driver);
		login2 = new KiteLogin2Page(driver);
		home = new KiteHomePage(driver);

	}

	@BeforeMethod
	public void loginToApp() {

		String UN = sh.getRow(0).getCell(0).getStringCellValue();
		login1.setKiteLogin1PageUsername(UN);

		String pwd = sh.getRow(0).getCell(1).getStringCellValue();
		login1.setKiteLogin1PagePassword(pwd);

		login1.clickKiteLogin1PageLoginButton();

		String pin = sh.getRow(0).getCell(2).getStringCellValue();
		login2.setKiteLogin2PagePIN(pin);

		login2.clickKiteLogin2PageContinue();
	}

	@Test
	public void verifyProfileName() {

		String exp = sh.getRow(0).getCell(3).getStringCellValue();
		home.verifyKiteHomePageProfileName(exp);

	}

	@AfterMethod
	public void logoutFromApp() {

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}

