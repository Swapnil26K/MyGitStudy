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
import com.acmt.pages.ProjectsPage;
import com.acmt.pages.TaxonomiesPage;
import com.acmt.setUp.SetUp;

//import myListener.Listener;

//@Listeners(Listener.class)
public class TestProjectsPage extends SetUp{
	
	HomePage homePage;
	LoginPage loginPageObject;	
	A_Home ahome;
	ProjectsPage projectsPage;
	BuildYourOwnThree buildYourOwnThree;
	
	public TestProjectsPage() throws IOException {
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
	public void verifyProjectsPageTitle() throws IOException
	{
		projectsPage=new ProjectsPage();
		projectsPage=ahome.clickProjects();
		String title=projectsPage.getProjectsPageTitle();
		if(title.equals("ACMT : Projects"))
		{
			System.out.println("Test Passed");
			System.out.println(title);
		}
		else
		{
			System.out.println("Test Failed");
		}
		System.out.println("Pehla Projects ka Method");
	}
	
	@Test(dependsOnGroups = { "CreateProject" },alwaysRun=true)
	public void verifyAddedProject() throws IOException
	{
		projectsPage=new ProjectsPage();
		projectsPage=ahome.clickProjects();
		//buildYourOwnThree.verifyCreatedTaxonomy();
		String title=projectsPage.checkAddedProject();
		if(title.equals("My Thirteenth Project"))
		{
			System.out.println("Test Passed");
			System.out.println(title);
		}
		else
		{
			System.out.println("Test Failed");
			System.out.println(title);
		}
		System.out.println("Doosra Projects ka Method");
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}

}
