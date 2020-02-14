package com.acmt.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acmt.pages.A_Home;
import com.acmt.pages.BuildYourOwnPage;
import com.acmt.pages.BuildYourOwnTwo;
import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.pages.TaxonomiesPage;
import com.acmt.setUp.SetUp;

public class TestBuildYourOwnTwoPage extends SetUp {

	LoginPage loginPageObject;
	HomePage homePage;
	A_Home ahome;
	TaxonomiesPage taxonomiesPage;
	BuildYourOwnPage buildYourOwnPage;
	BuildYourOwnTwo buildYourOwnTwo;
	
	public TestBuildYourOwnTwoPage() throws IOException {
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
		buildYourOwnPage.waitForElement();
		buildYourOwnTwo=buildYourOwnPage.clickBuildYourOwnBox();
	}
	
	@Test
	public void verifyCreateNewTaxonomy() throws IOException
	{
		buildYourOwnTwo.waitForElement();
		String headerText=buildYourOwnTwo.verifyBuildYourOwnPage();
		if(headerText.equals("Step 2 of 3"))
		{
			System.out.println("Test Passed");
			System.out.println(headerText);
		}
		else
		{
			System.out.println("Test Failed");
		}
	}

}
