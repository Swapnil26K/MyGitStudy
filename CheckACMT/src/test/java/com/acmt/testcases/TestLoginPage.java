package com.acmt.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.acmt.pages.A_Home;
import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.setUp.SetUp;

public class TestLoginPage extends SetUp{
	
	LoginPage loginPageObject;
	HomePage homePage;
	A_Home ahome;
	
	public TestLoginPage() throws IOException {
		super();
		ahome=new A_Home();
		homePage=new HomePage();
		loginPageObject=new LoginPage();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{		
		//loginPageObject=new LoginPage();
		//homePage=new HomePage();
		initialization();
		loginPageObject=new LoginPage();
		homePage=new HomePage();
	}
	
	@Test
	public void verifyLoginPageTitle() throws IOException, InterruptedException
	{
		loginPageObject=homePage.clickLoginButton();
		String checkIfLogin=loginPageObject.verifyLoginPageTitle();
		if(checkIfLogin.equals("ACMT : Login"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
	}
	
	
	  @Test 
	  public void verifyLoginSuccess() throws IOException, InterruptedException 
	  {
		  loginPageObject=homePage.clickLoginButton();
		  ahome=loginPageObject.login();		  
	  }
	 
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

	
}
