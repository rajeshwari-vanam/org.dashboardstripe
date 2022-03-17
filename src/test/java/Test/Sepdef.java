package Test;

import java.util.List;
import java.util.Map;



import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sepdef 
{
	// declare objects as global to use in all step def mathods
	public RemoteWebDriver driver;
	public Loginpage obj1;
	public CustomerPage obj2;
	public LogoutPage obj3;
	public RecaptchaPage obj4;
	 public VerificationPage obj5;
	
	@Given("open {string} browser")
	public void method1(String bn)
	{
		 if(bn.equalsIgnoreCase("chrome"))
	 	  {
	 		 WebDriverManager.chromedriver().setup();//create parent class object using child class constructor
	 		 driver=new ChromeDriver();
	 	  }
	 	  else if(bn.equalsIgnoreCase("firefox"))
	 	  {
	 		  WebDriverManager.firefoxdriver().setup();
	 		  driver=new FirefoxDriver();
	 	  }
	 	  else if(bn.equalsIgnoreCase("opera"))
	 	  {
	 		  WebDriverManager.operadriver().setup();
	 		  driver=new OperaDriver();
	 	  }
	 	  else
	 	  {
	 		  WebDriverManager.edgedriver().setup();
	 		  driver=new EdgeDriver();
	 	  }
		  // define objects
		  obj1= new Loginpage(driver);
		  obj2=new CustomerPage(driver);
		  obj3= new LogoutPage(driver);
		  //obj4=new RecaptchaPage(driver);
		  obj5=new VerificationPage(driver);
		  
	}

	@Given("launch site using {string}")
	public void method2(String url) throws Exception 
	{
	   driver.get(url);
	   Thread.sleep(5000);
	}

	@When("do login using {string} and {string} credentials")
	public void method3(String uid, String pwd) throws Exception 
	{
	    obj1.fillUserName(uid);
	    obj1.fillPassword(pwd);
	    obj1.clickContinue();
	    obj5.clickskipForNow();
	    
	}

	@Then("customers tab should be displayed")
	public void method4() 
	{
	   if(obj2.iscustomersDisplayed()) 
	   {
		   System.out.println("customers link is dispalyed");
	   }
	   else
	   {
		   System.out.println("customers link is not dispalyed");
		   System.exit(0);
	   }
	}

	@When("add customers and verify")
	public void method5(DataTable dt) throws Exception 
	{
	    // take data from table
		List<Map<String,String>>l=dt.asMaps();
		for(int i=0;i<l.size();i++)
		{
			// click on customers
			obj2.clickcustomers();
			//  add customer
			obj2.clickAddcustomer();
			obj2.fillName(l.get(i).get("name"));
			obj2.fillEmail(l.get(i).get("e mail"));
			obj2.fillDescription(l.get(i).get("description"));
			obj2.clickAdd();
		}
		if(obj2.isOuputMsgDisplayed())
		{
			System.out.println("successful adding of a customer");
		}
		else
		{
			System.out.println("unsuccessful adding of a customer");
		}
		
	}

	@When("do logout")
	public void method6() throws Exception 
	{
	  obj3.clickprofilepic();
	  obj3.clickSignout();
	}

	@Then("login page should be displayed")
	public void method7()
	{
	    if(obj3.isLoginRedisplayed())
	    {
	    	System.out.println("sucessful logout");
	    }
	    else
	    {
	    	System.out.println("unsucessful logout");
	    	System.exit(0);
	    }
	}

	@When("close site")
	public void method8()
	{
	    driver.close();
	}
}
