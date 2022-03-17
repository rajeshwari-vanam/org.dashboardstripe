package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage 
{
  // element locators
	@FindBy(xpath="//span[text()='Customers']/ancestor::a")
	public WebElement customers;
	@FindBy(xpath="//span[text()='Add customer']/ancestor::button")
	public WebElement addcustomer;
	@FindBy(xpath="//input[contains(@name,'name')]")
	public WebElement name;
	@FindBy(name="email")
	public WebElement email;
	@FindBy(name="description")
	public WebElement description;
	@FindBy(xpath="(//span[text()='Add customer']/ancestor::button)[2]")
	public WebElement add;
	@FindBy(xpath="//span[text()='Customer created']")
	public WebElement outputmsg;
	
	// constructor method
	public CustomerPage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 // operational and observation methods
	
		public boolean iscustomersDisplayed()
		{
			try 
			{
				if(customers.isDisplayed())
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
				return (false);
				
			}
			
		}
		public void clickcustomers() throws Exception
		{
			customers.click();
			Thread.sleep(10000);
		}
		public void clickAddcustomer() throws Exception
		{
			addcustomer.click();
			Thread.sleep(20000);
		}
		public void fillName(String x)
		{
			name.sendKeys(x);
		}
		public void fillEmail(String x)
		{
			email.sendKeys(x);
		}
		public void fillDescription(String x)
		{
			description.sendKeys(x);
		}
		public void clickAdd() throws Exception
		{
			add.click();
			Thread.sleep(5000);
		}
		public boolean isOuputMsgDisplayed()
		{
			try
			{
				if(outputmsg.isDisplayed())
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
