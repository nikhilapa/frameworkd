package TestNG_POM_DDF;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KiteLoginTest1NG extends BaseClass
{
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	KiteHomePage home;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {

		browserOpen();
		login1 = new KiteLogin1Page(driver);
		login2 = new KiteLogin2Page(driver);
		home = new KiteHomePage(driver);

	}

	@BeforeMethod
	public void loginToApp() throws EncryptedDocumentException, IOException {

		login1.setKiteLogin1PageUsername(Utility.getTestData(0, 0));

		login1.setKiteLogin1PagePassword(Utility.getTestData(0, 1));

		login1.clickKiteLogin1PageLoginButton();

		login2.setKiteLogin2PagePIN(Utility.getTestData(0, 2));

		login2.clickKiteLogin2PageContinue();
	}

	@Test
	public void verifyProfileName() throws EncryptedDocumentException, IOException {

		home.verifyKiteHomePageProfileName(Utility.getTestData(0, 3));

	}

	@AfterMethod
	public void logoutFromApp() {

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}


}
