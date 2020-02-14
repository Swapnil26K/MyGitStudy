package com.acmt.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acmt.pages.A_Home;
import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.setUp.SetUp;

public class TestACMTHome extends SetUp{

	LoginPage loginPageObject;
	HomePage homePage;
	A_Home ahome;
	
	public TestACMTHome() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{		
		//loginPageObject=new LoginPage();
		//homePage=new HomePage();
		initialization();
		homePage=new HomePage();
		loginPageObject=homePage.clickLoginButton();		
		ahome=loginPageObject.login();
	}
	
	@Test
	public void verifyAcmtHomeTitle()
	{
		ahome.waitForElement();
		String title=ahome.verifyAcmtHomePageTitle();		
		if(title.equals("ACMT : Home"))
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
