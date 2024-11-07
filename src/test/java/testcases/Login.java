package testcases;

import static utility.Report.test;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
// Step defination file..
public class Login extends Hook
{
	public static boolean uiid = false;
	public static boolean x = false;
	public static boolean login = false;
	
	@Given("i open {string} and get url {string} and create report {string} for testname {string}")
	public void i_open_and_get_url_and_create_report_for_testname(String browser, String url, String reportname, String testname) throws Exception 
	{
	    openBrowser(browser,url,reportname,testname);
	}
	@Given("i click on signin link")
	public void i_click_on_signin_link() 
	{
	    signin.click();
	}
	@When("I enter valid userid {string}")
	public void i_enter_valid_userid(String email) 
	{
		userid.sendKeys(email);
	}
	@When("click continue button")
	public void click_continue_button() 
	{
	    ctnbtn.click();
	}
	@Then("I validate error message should not come")
	public void i_validate_error_message_should_not_come() 
	{
		try {
			  String txt = err1.getText();
			  test.log(Status.FAIL, MarkupHelper.createLabel("user id is not valid.."+txt, ExtentColor.RED));
			  Assert.fail(txt);
			    }
			    catch(Exception e)
			    {
			    	uiid = true;
			    	test.log(Status.PASS, MarkupHelper.createLabel("user id is valid..1", ExtentColor.GREEN));
			    }
	}

	@Given("userid is valid")
	public void userid_is_valid() 
	{
	    if(uiid == true)
	    {
	    	x = true;
	    }
	    else
	    {
	    	test.log(Status.FAIL, MarkupHelper.createLabel("user id is not valid..2", ExtentColor.RED));
			  
	    }
	}
	@When("entered a valid password that is {string}")
	public void entered_a_valid_password_that_is(String pwd) 
	{
	    if(x == true)
	    {
	    	System.out.println(".................aaaaaaaaa..........");
	    	password.sendKeys(pwd);
	    	submit.click();
	    }
	}
	@Then("i should login")
	public void i_should_login() 
	{
		try {
			  String txt = err2.getText();
			  test.log(Status.FAIL, MarkupHelper.createLabel("password is not valid.."+txt, ExtentColor.RED));
			  Assert.fail(txt);
			    }
			    catch(Exception e)
			    {
			    	login = true;
			    	test.log(Status.PASS, MarkupHelper.createLabel("password is valid..", ExtentColor.GREEN));
			    }
		
		
	}


}
