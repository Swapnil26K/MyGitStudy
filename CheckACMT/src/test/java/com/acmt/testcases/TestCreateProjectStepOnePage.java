package com.acmt.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acmt.pages.A_Home;
import com.acmt.pages.BuildYourOwnPage;
import com.acmt.pages.CreateProjectStepOnePage;
import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.pages.ProjectsPage;
import com.acmt.setUp.SetUp;

public class TestCreateProjectStepOnePage extends SetUp{
	
	HomePage homePage;
	LoginPage loginPageObject;	
	A_Home ahome;
	ProjectsPage projectsPage;
	CreateProjectStepOnePage createProjectStepOnePage;
	
	public TestCreateProjectStepOnePage() throws IOException {
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
		projectsPage=ahome.clickProjects();
		createProjectStepOnePage=new CreateProjectStepOnePage();					
	}
	
	@Test
	public void verifyCreateNewProject() throws IOException
	{
		createProjectStepOnePage=projectsPage.clickCreateNewProject();
		createProjectStepOnePage.waitForElement();
		String headerText=createProjectStepOnePage.verifyCreateProjectStepOnePage();
		if(headerText.equals("Step 1 of 2"))
		{
			System.out.println("Test Passed");
			System.out.println(headerText);
		}
		else
		{
			System.out.println("Test Failed");
			System.out.println(headerText);
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
