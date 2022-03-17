package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
  
	// define locators
	@FindBy(xpath="//*[name()='svg'and@id='menu7-button']/*[name()='path']")
	public WebElement profilepic;
	@FindBy(xpath="//span[text()='Sign out']/ancestor::button")
	public WebElement signout;
	@FindBy(xpath="//span[text()='Sign in to your account']")
	public WebElement relogin;
   
	 
	// constructor method
	public  LogoutPage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// operaional and obsevartion methods
	public void clickprofilepic() throws Exception
	{
		profilepic.click();
		Thread.sleep(5000);
    }
	public void clickSignout() throws Exception
	{
		signout.click();
		Thread.sleep(10000);
	}
	public boolean isLoginRedisplayed()
	{
		try 
		{
			if(relogin.isDisplayed())
			{
				return(true);	
			}
			else
			{
				return(false);
			}
		}
		catch(Exception ex)
		{
			return(false);
			
		}
	}
	
	
}
