package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import Lib.excelConfig;

public class searchAddItem {
	
public WebDriver fdriver;
	
	
	public searchAddItem(WebDriver driver){
		fdriver =  driver;
	}
	
	//Setting the Search test in Excel only. If next time we need to search some other test then we need to update at one place only.
	//
	excelConfig excel = new excelConfig("//home//sumit//workspace//PayjoFlipkartAssignment//TestData.xlsx"); //We need to provide the Excel path here.
	String iPhone = excel.getData(0, 0, 2);
	
	public void Searchitem(){
		//This function will Search the Product.
		
		try {
			Thread.sleep(2000); // Used due to Synchronous error.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} //Try Catch is to Avoid the Exception error.
		
		fdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		fdriver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[1]/div/input")).sendKeys("Iphone 7");
		fdriver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[2]/button")).sendKeys(Keys.RETURN);
		
		//Above line of code is Searching for Iphone 7 on Flipkart.
	
		System.out.println("Item has been searched.!");
	}
	
	public void AddtoCart(){
		
		//This FUnction is going to add Searched Product into Cart. At the same time it is going to compare the Added product and Procuct in Cart.
		
		fdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		fdriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div[1]/a/div[1]/div[1]/div[1]/div/img")).click();
		
		String productDetail = fdriver.findElement(By.xpath("//*[@class='_3eAQiD']")).getText();
		
		System.out.println("Product test is:" +productDetail);
		
		fdriver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div/div/div[1]/div/div[1]/div[2]/ul/li[1]/button")).click();
		
		String Cartitem = fdriver.findElement(By.xpath("//*[@class='_325-ji _3ROAwx']")).getText();
		System.out.println("Cartitem text is:" +Cartitem);
		
		//Comparing is done over here.
		if(productDetail == Cartitem){
			
			System.out.println(productDetail + "Match with:" + Cartitem);
		}
		
		else{
			System.out.println(productDetail + "Does not Match with " + Cartitem);
		}
	}

}
