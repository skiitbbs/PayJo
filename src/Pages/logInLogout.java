package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Lib.excelConfig;

public class logInLogout {
	
	public WebDriver fdriver;
	
	
	public logInLogout(WebDriver driver){
		fdriver =  driver; //Constructor to make sure communication between this class and executing class happen smoothly.
	}
	
	//Below line of excel code is going to import the data from excel.
	excelConfig excel = new excelConfig("//home//sumit//workspace//PayjoFlipkartAssignment//TestData.xlsx");
	String email = excel.getData(0, 0, 0);
	String pass = excel.getData(0, 0, 1);

	
	public void Login(){
		
		//This function is going to Login into Flipkart. 
		
		fdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		fdriver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div[1]/div/ul/li[9]/a")).click();
		fdriver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(email);
		fdriver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(pass);
		fdriver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div/form/div[3]/button/span")).click();
		
		WebDriverWait wait = new WebDriverWait(fdriver, 30);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[8]/a")));
	}
	
	public void Logout(){
		
		//This function is going to Logout from Flipkart.
		
		fdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement Logout = fdriver.findElement(By.xpath("//*[@id='container']/div/header/div/div[1]/div/ul/li/a"));
		Actions hover = new Actions(fdriver);
		hover.moveToElement(Logout).moveToElement(fdriver.findElement(By.xpath("//*[@id='container']/div/header/div/div[1]/div/ul/li/ul/li[9]/a"))).build().perform();
		hover.moveToElement(fdriver.findElement(By.xpath("//*[@id='container']/div/header/div/div[1]/div/ul/li/ul/li[9]/a"))).click().build().perform();
		
		System.out.println("User is Loged Out.");
		
	}

}
