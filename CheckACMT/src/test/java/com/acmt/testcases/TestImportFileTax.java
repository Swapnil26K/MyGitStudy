package com.acmt.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.acmt.pages.A_Home;
import com.acmt.pages.BuildYourOwnPage;
import com.acmt.pages.BuildYourOwnThree;
import com.acmt.pages.BuildYourOwnTwo;
import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.pages.TaxonomiesPage;
import com.acmt.setUp.SetUp;
//import org.apache.log4j.Logger;


public class TestImportFileTax extends SetUp
{
	LoginPage loginPageObject;
	HomePage homePage;
	A_Home ahome;
	TaxonomiesPage taxonomiesPage;
	BuildYourOwnPage buildYourOwnPage;
	BuildYourOwnTwo buildYourOwnTwo;
	BuildYourOwnThree buildYourOwnThree;
	static Logger log = Logger.getLogger(TestImportFileTax.class);
	
	public TestImportFileTax() throws IOException 
	{
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{		
		//loginPageObject=new LoginPage();
		//homePage=new HomePage();
		initialization();
		log.debug("Initialized successfully");
		homePage=new HomePage();		
		loginPageObject=homePage.clickLoginButton();		
		ahome=loginPageObject.login();
		taxonomiesPage=ahome.clickTaxonomies();
		buildYourOwnPage=new BuildYourOwnPage();
		buildYourOwnPage=taxonomiesPage.clickCreateNewTaxonomy();	
		buildYourOwnPage.waitForElement();
		buildYourOwnTwo=buildYourOwnPage.importFile();
		buildYourOwnTwo.waitForElement();
		buildYourOwnThree=new BuildYourOwnThree();
		buildYourOwnThree=buildYourOwnTwo.uploadFile();
		//myLogger.info("Before Method of Import File executed successfully");
		//buildYourOwnThree.waitForElement();			
	}
	
	@Test
	public void checkImportTaxonomy() throws IOException
	{
		buildYourOwnThree.finishImportingTaxonomy();
		log.debug("test executed successfully");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.debug("Tear Down executed successfully");
	}

}
