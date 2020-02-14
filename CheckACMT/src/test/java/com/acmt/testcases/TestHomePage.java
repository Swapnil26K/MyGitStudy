package com.acmt.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.acmt.pages.HomePage;
import com.acmt.setUp.SetUp;

public class TestHomePage extends SetUp{
	
	
	public TestHomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
	}
	
	@Test
	public void verifyHome() throws IOException
	{
		HomePage homePageObject=new HomePage();
		String checkIfHome=homePageObject.verifyHomeLink();
		if(checkIfHome.contains("HOME"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
