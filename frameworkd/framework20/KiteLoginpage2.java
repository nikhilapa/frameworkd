package framework20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginpage2 
{
	@FindBy(xpath="//input[@id='pin']")
	private WebElement PIN;
	
	@FindBy(xpath = "//button[text()='Continue ']")
	private WebElement cnt;

	public KiteLoginpage2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setKiteLogin2PagePIN(String PinValue) 
	{
		PIN.sendKeys(PinValue);
	}

	public void clickKiteLogin2PageContinue() 
	{
		cnt.click();
	}

}
