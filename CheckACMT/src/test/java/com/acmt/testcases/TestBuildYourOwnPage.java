package com.acmt.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acmt.pages.A_Home;
import com.acmt.pages.BuildYourOwnPage;
import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.pages.TaxonomiesPage;
import com.acmt.setUp.SetUp;

public class TestBuildYourOwnPage extends SetUp {
	
	LoginPage loginPageObject;
	HomePage homePage;
	A_Home ahome;
	TaxonomiesPage taxonomiesPage;
	BuildYourOwnPage buildYourOwnPage;

	public TestBuildYourOwnPage() throws IOException {
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
		taxonomiesPage=ahome.clickTaxonomies();
		buildYourOwnPage=new BuildYourOwnPage();
		buildYourOwnPage=taxonomiesPage.clickCreateNewTaxonomy();				
	}
	
	@Test
	public void verifyCreateNewTaxonomy() throws IOException
	{
		buildYourOwnPage.waitForElement();
		String headerText=buildYourOwnPage.verifyBuildYourOwnPage();
		if(headerText.equals("Step 1 of 3"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
	}

}
