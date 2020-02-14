package com.acmt.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.acmt.pages.A_Home;
import com.acmt.pages.BuildYourOwnThree;
import com.acmt.pages.HomePage;
import com.acmt.pages.InsideTaxonomy;
import com.acmt.pages.LoginPage;
import com.acmt.pages.TaxonomiesPage;
import com.acmt.setUp.SetUp;

@Listeners(com.acmt.pages.Listener.class)
public class TestInsideTaxonomyPage extends SetUp{
	
	LoginPage loginPageObject;
	HomePage homePage;
	A_Home ahome;
	TaxonomiesPage taxonomiesPage;
	BuildYourOwnThree buildYourOwnThree;
	InsideTaxonomy insideTaxonomy;
	
	public TestInsideTaxonomyPage() throws IOException {
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
	
	@Test(dependsOnGroups = { "CreatedTaxonomy" },alwaysRun=true)
	public void verifyInsideTaxonomy() throws IOException
	{
		taxonomiesPage=new TaxonomiesPage();
		taxonomiesPage=ahome.clickTaxonomies();
		//buildYourOwnThree.verifyCreatedTaxonomy();
		insideTaxonomy=new InsideTaxonomy();
		insideTaxonomy=taxonomiesPage.clickAddedTaxonomy();
		String title=insideTaxonomy.getTaxonomyText();
		if(title.equals("My States API Standards"))
		{
			System.out.println("Test Passed");
			System.out.println(title);
		}
		else
		{
			System.out.println("Test Failed");
			System.out.println(title);
		}
		System.out.println("Doosra Inside Taxonomy ka Method");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
