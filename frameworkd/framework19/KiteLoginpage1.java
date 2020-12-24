package framework19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginpage1 
{
	@FindBy(xpath = "//input[@id='userid']")
	private WebElement UN;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement pwd;
	
	@FindBy(xpath = "//button[text()='Login ']")
	private WebElement login;

//initialization
	public KiteLoginpage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setKiteLogin1PageUsername(String username) {
		UN.sendKeys(username);
	}

	public void setKiteLogin1PagePassword(String password) {
		pwd.sendKeys(password);
	}

	public void clickKiteLogin1PageLoginButton() {
		login.click();
	}


}
