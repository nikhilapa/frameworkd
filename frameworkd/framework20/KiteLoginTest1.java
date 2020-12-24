package framework20;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestNG_POM_DDF.Utility;

public class KiteLoginTest1 extends BaseClass 
{
	KiteLoginpage1 login1;
	KiteLoginpage2 login2;
	KiteHomepage home;
	int TCID;
    @Parameters("browserName")
	@BeforeClass
	public void openBrowser(String browserName) throws EncryptedDocumentException, IOException 
	{

		browserOpen(browserName);
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
	public void verifyProfileName() throws EncryptedDocumentException, IOException
	{
		TCID = 200;
		String actResult = home.getKiteHomePageProfileName();
		String expResult = Utility.getTestData(0, 3);

		Assert.assertEquals(actResult, expResult, "act & exp result results are not same");
	}

	@AfterMethod
	public void logoutFromApp(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			Utility1.captureScreenshot(driver, TCID);
		}	
	}

	@AfterClass
	public void closeBrowser() 
	{
		driver.close();
	}


}
