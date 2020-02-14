package com.acmt.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.acmt.pages.A_Home;
import com.acmt.pages.BuildYourOwnPage;
import com.acmt.pages.BuildYourOwnThree;
import com.acmt.pages.BuildYourOwnTwo;
import com.acmt.pages.HomePage;
import com.acmt.pages.InsideTaxonomy;
import com.acmt.pages.LastPublishPage;
import com.acmt.pages.LoginPage;
import com.acmt.pages.TaxonomiesPage;
import com.acmt.setUp.SetUp;

@Listeners(com.acmt.pages.Listener.class) 
public class TestLastPublishPage extends SetUp{
	
	LoginPage loginPageObject;
	HomePage homePage;
	A_Home ahome;
	TaxonomiesPage taxonomiesPage;
	BuildYourOwnThree buildYourOwnThree;
	InsideTaxonomy insideTaxonomy;
	LastPublishPage lastPublishPage;
	
	public TestLastPublishPage() throws IOException {
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
		ahome.waitForElement();
		taxonomiesPage=new TaxonomiesPage();
		taxonomiesPage=ahome.clickTaxonomies();
		//buildYourOwnThree.verifyCreatedTaxonomy();
		insideTaxonomy=new InsideTaxonomy();
		insideTaxonomy=taxonomiesPage.clickAddedTaxonomy();		
		insideTaxonomy.waitForText();
	}
	
	//(dependsOnGroups = { "CreatedTaxonomy" },alwaysRun=true)
	
	@Test
	public void verifyInsideTaxonomy() throws IOException
	{
		lastPublishPage=new LastPublishPage();
		lastPublishPage=insideTaxonomy.clickPublishTab();
		lastPublishPage.waitForText();
		String title=lastPublishPage.getTitle();
		if(title.equals("Publish"))
		{
			System.out.println("Test Passed");
			System.out.println(title);
		}
		else
		{
			System.out.println("Test Failed");
			System.out.println(title);
		}
		lastPublishPage.publishIt();
		
		System.out.println("Pehla Last Publish Page ka Method");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
