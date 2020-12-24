package framework19;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestNG_POM_DDF.Utility;

public class KiteLoginTest1 extends BaseClass 
{
	KiteLoginpage1 login1;
	KiteLoginpage2 login2;
	KiteHomepage home;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException 
	{

		browseropen();
		login1 = new KiteLoginpage1(driver);
		login2 = new KiteLoginpage2(driver);
		home = new KiteHomepage(driver);
		
	}
	@BeforeMethod
	public void logintoapp() throws EncryptedDocumentException, IOException
	{
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
	public void logoutFromApp() 
	{

	}

	@AfterClass
	public void closeBrowser() 
	{
		driver.close();
	}


}
