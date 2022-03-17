package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
  //  define element locators
	@FindBy(name="email")
	public WebElement username;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(xpath="//span[text()='Continue']/ancestor::button")
    public WebElement signin;
	
    // construtor method
	
	public Loginpage(RemoteWebDriver driver)
	{
		// connect driver object to above defined locators
		PageFactory.initElements(driver, this);
	}
		// oerational and observation methods
	 public void fillUserName(String x)
	 {
 // before going to opearte an element ,driver object uses above locator to locate element called as lazy initializaton
		 username.sendKeys(x);
	 }
	 public void fillPassword(String x)
	 {
		 // locate element and operator
		 password.sendKeys(x);
	 }
     public void clickContinue() throws Exception
     {
    	 signin.click();
    	 Thread.sleep(20000);
     }
    
	
}
