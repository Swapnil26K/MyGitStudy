package com.frost.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.setUp.SetUp;
import com.frost.pages.FrostHomePage;
import com.frost.pages.FrostLoginPage;

public class TestFrostHomePage extends SetUp
{
	FrostLoginPage frostLoginPageObject;
	FrostHomePage frosthomePage;
	
	public TestFrostHomePage() throws IOException 
	{
		super();		
		frosthomePage = new FrostHomePage();
		
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{		
		initialization();			
		frostLoginPageObject = new FrostLoginPage();
		frostLoginPageObject.waitForElement();
		frosthomePage=frostLoginPageObject.login();
	}
	
	@Test
	public void verifyFrostHomeTitle()
	{
		//ahome.waitForElement();
		String userNameText=frosthomePage.verifyHomePageText();		
		if(userNameText.equals("Welcome Swapnil"))
		{
			System.out.println("Test Passed");
			System.out.println(userNameText);
		}
		else
		{
			System.out.println("Test Failed");
			System.out.println(userNameText);
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
