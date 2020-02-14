package com.acmt.testcases;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.acmt.pages.A_Home;
import com.acmt.pages.CreateProjectStepOnePage;
import com.acmt.pages.CreateProjectStepTwoPage;
import com.acmt.pages.HomePage;
import com.acmt.pages.LoginPage;
import com.acmt.pages.ProjectsPage;
import com.acmt.setUp.SetUp;

public class TestCreateProjectStepTwoPage extends SetUp{
	
	HomePage homePage;
	LoginPage loginPageObject;	
	A_Home ahome;
	ProjectsPage projectsPage;
	CreateProjectStepOnePage createProjectStepOnePage;
	CreateProjectStepTwoPage createProjectStepTwoPage;	
	
	public TestCreateProjectStepTwoPage() throws IOException {
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
		createProjectStepOnePage=projectsPage.clickCreateNewProject();
		createProjectStepOnePage.waitForElement();
		createProjectStepOnePage.enterProjectName();
		//createProjectStepOnePage.enterProjectDescription();
		createProjectStepOnePage.selectWorkFlow();
		createProjectStepOnePage.selectTaxonomy();	
		createProjectStepOnePage.checkTaxonomy();
	}
	
	@Test(groups="CreateProject")
	public void verifyCreateNewProject() throws IOException, InterruptedException
	{	
		createProjectStepTwoPage=new CreateProjectStepTwoPage();
		createProjectStepTwoPage=createProjectStepOnePage.clickCreateButton();
		String headerText=createProjectStepTwoPage.verifyCreateProjectStepOnePage();
		if(headerText.equals("Step 2 of 2"))
		{
			System.out.println("Test Passed");
			System.out.println(headerText);
		}
		else
		{
			System.out.println("Test Failed");
			System.out.println(headerText);
		}
		Thread.sleep(25);
		createProjectStepTwoPage.clickDoneButton();
		System.out.println("Pehla BuildYourOwnThreePage ka Method");
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}
}
