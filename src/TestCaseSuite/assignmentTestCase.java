package TestCaseSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.logInLogout;
import Pages.searchAddItem;

public class assignmentTestCase {
	
	WebDriver driver;
	
	@BeforeTest
 	private WebDriver getBrowser() 
 	{
	
	System.setProperty("webdriver.chrome.driver","//home//sumit//Downloads//chromedriver");
	driver= new ChromeDriver(); // Create a new instance for the Chrome Driver.
	driver.manage().window().maximize();
	return driver;
     }


 	@Test
 	public void UserActionsOnFlipkart(){
	
 	//this is the first test case which will login into flipkart, then Search for the Product and then add searched itme into Cart.
	
	String url = "https://www.flipkart.com/";
	driver.get(url); 
	
	
	logInLogout login = new logInLogout(driver); //Initializing LoginLogout Class.
	
	
	login.Login(); //Calling Login Function.
	
	System.out.println("User has beeen succcessfuly Logged In");
	
	
	searchAddItem search = new searchAddItem(driver); //Initializing Search Class.
	
	search.Searchitem(); //Calling Search function.
	
	search.AddtoCart(); //Calling Add to Cart function.
	
	login.Logout(); //Calling Logout function.
	
	driver.close();
	
	
 	}
	
	
}
