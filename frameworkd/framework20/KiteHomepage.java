package framework20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomepage 
{
	
	@FindBy(xpath="//span[text()='KV']")
	private WebElement PN;
	
	public KiteHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public String getKiteHomePageProfileName()
	{
		String act = PN.getText();
		return act;
	}
}
