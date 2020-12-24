package POM;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KiteLoginTest
{
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		FileInputStream file =new FileInputStream("E:\\Velo\\Sept20.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		System.setProperty("webdriver.chrome.driver","E:\\Velo\\sel\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		KiteLogin1Page login1 = new KiteLogin1Page(driver);
		
		
		String UN = sh.getRow(0).getCell(0).getStringCellValue();
		login1.setKiteLogin1PageUsername(UN);
		 
		String pwd = sh.getRow(0).getCell(1).getStringCellValue();
		login1.setKiteLogin1PagePassword(pwd);
		
		login1.clickKiteLogin1PageLoginButton();

		KiteLogin2Page login2 = new KiteLogin2Page(driver);
		
		String pin = sh.getRow(0).getCell(2).getStringCellValue();
		login2.setKiteLogin2PagePIN(pin);
		
		login2.clickKiteLogin2PageContinue();

		KiteHomePage home = new KiteHomePage(driver);
		
		String exp = sh.getRow(0).getCell(3).getStringCellValue();
		home.verifyKiteHomePageProfileName(exp);

		Thread.sleep(5000);
		driver.close();

	}

}
