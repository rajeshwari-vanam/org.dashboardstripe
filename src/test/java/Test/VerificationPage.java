package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationPage
{
 // element locators
	@FindBy(xpath="//span[text()='Skip for now']/..")
	public WebElement skip;
	
	// constructor method
	public VerificationPage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	} 
	
	// operational and observation methods
	public void clickskipForNow() throws Exception
	{
		try 
		{
			skip.click();
			Thread.sleep(10000);
		}
		catch(Exception ex)
		{
			System.out.println("verification page doesnot exist");
		}
	}
}
