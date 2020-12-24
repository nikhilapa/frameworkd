package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
	@FindBy(xpath="//span[text()='KV']")
	private WebElement PN;
	
	
	public KiteHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyKiteHomePageProfileName(String exp) {
		String act = PN.getText();
		if (act.equals(exp)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

}
