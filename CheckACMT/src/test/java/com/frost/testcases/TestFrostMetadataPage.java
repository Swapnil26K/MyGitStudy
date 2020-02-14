package com.frost.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frost.setUp.SetUp;
import com.frost.pages.FrostHomePage;
import com.frost.pages.FrostLoginPage;
import com.frost.pages.FrostMetadataPage;

public class TestFrostMetadataPage extends SetUp
{
	FrostLoginPage frostLoginPageObject;
	FrostHomePage frosthomePage;
	FrostMetadataPage frostMetadataPage;
	
	public TestFrostMetadataPage() throws IOException 
	{
		super();		
		
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{		
		initialization();	
		frostLoginPageObject = new FrostLoginPage();
		frostLoginPageObject.waitForElement();
		frosthomePage=frostLoginPageObject.login();
		frostMetadataPage=new FrostMetadataPage();
		frosthomePage = new FrostHomePage();
		frostMetadataPage=frosthomePage.clickMetaData();
	}
	
	@Test
	public void verifyFrostHomeTitle() throws InterruptedException
	{
		//ahome.waitForElement();
		frostMetadataPage.selectCaseServer();
		frostMetadataPage.selectTaxonomy();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
