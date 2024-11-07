package testcases;

import static utility.Report.test;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearch 
{
	public static boolean x = false;
	
	@Given("user is logged in")
	public void user_is_logged_in() 
	{
	    if(Login.login == true)
	    {
	    	x = true;
	    }
	}
	@When("^i search for (.*) in price (.*)")
	public void i_search_for_shirt_in_price(String product,int price) 
	{
	    if(x == true)
	    {
	    	Hook.searchtxtbox.clear();
	    	Hook.searchtxtbox.sendKeys(product+" in range "+price);
	    }
	}
	@Then("search results must come")
	public void search_results_must_come() throws Exception 
	{
		Actions a = new Actions(Hook.driver);
		  a.sendKeys(Keys.ENTER).perform();
		   Thread.sleep(4000);
		   
		   Iterator <WebElement> it =  Hook.searchresult.iterator();
			
			 for(int i =1; i <= 5; i++)
			 {
				WebElement e = it.next();
			String dsp =	e.getText();
			test.log(Status.PASS, MarkupHelper.createLabel("searchresult .."+dsp, ExtentColor.GREEN));
			  
			 }
	}



}
