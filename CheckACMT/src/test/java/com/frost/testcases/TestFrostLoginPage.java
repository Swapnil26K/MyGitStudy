package com.frost.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.setUp.SetUp;
import com.frost.pages.FrostLoginPage;

public class TestFrostLoginPage extends SetUp 
{
	FrostLoginPage frostLoginPageObject;
	public TestFrostLoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{		
		initialization();				
	}
	
	@Test
	public void verifyLoginPageTitle() throws IOException, InterruptedException
	{
		frostLoginPageObject=new FrostLoginPage();
		String checkIfLogin=frostLoginPageObject.verifyLoginPageTitle();
		if(checkIfLogin.equals("FROST"))
		{
			System.out.println("Test Passed");
			System.out.println(checkIfLogin);
		}
		else
		{
			System.out.println("Test Failed");
			System.out.println(checkIfLogin);
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

}
