package com.acmt.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.acmt.pages.A_Home;
import com.acmt.pages.BuildYourOwnThree;
import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.pages.TaxonomiesPage;
import com.acmt.setUp.SetUp;

@Listeners(com.acmt.pages.Listener.class)
public class TestTaxonomiesPage extends SetUp{
	
	LoginPage loginPageObject;
	HomePage homePage;
	A_Home ahome;
	TaxonomiesPage taxonomiesPage;
	BuildYourOwnThree buildYourOwnThree;
	
	public TestTaxonomiesPage() throws IOException {
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
	}
	
	@Test
	public void verifyTaxonomyPageTitle() throws IOException
	{
		taxonomiesPage=new TaxonomiesPage();
		taxonomiesPage=ahome.clickTaxonomies();
		String title=taxonomiesPage.getTaxonomiesPageTitle();
		if(title.equals("ACMT : Taxonomies"))
		{
			System.out.println("Test Passed");
			System.out.println(title);
		}
		else
		{
			System.out.println("Test Failed");
		}
		System.out.println("Pehla Taxonomy ka Method");
	}
	
	@Test(dependsOnGroups = { "CreatedTaxonomy" },alwaysRun=true)
	public void verifyAddedTaxonomy() throws IOException
	{
		taxonomiesPage=new TaxonomiesPage();
		taxonomiesPage=ahome.clickTaxonomies();
		//buildYourOwnThree.verifyCreatedTaxonomy();
		String title=taxonomiesPage.checkAddedTaxonomy();
		if(title.equals("My States API Standards"))
		{
			System.out.println("Test Passed");
			System.out.println(title);
		}
		else
		{
			System.out.println("Test Failed");
		}
		System.out.println("Doosra Taxonomy ka Method");
	}
	
	/*
	 * @Test public void verifyAdditionOfNodes() { taxonomiesPage.addNodes(); }
	 */
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
