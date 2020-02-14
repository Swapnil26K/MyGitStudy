package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acmt.setUp.SetUp;

public class ProjectsPage extends SetUp {
	
	@FindBy(xpath="//button[contains(text(),'Create New Project')]")
	WebElement createNewProject;
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 tbody']//div//div")
	WebElement myAddedProject;
	
	public ProjectsPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String getProjectsPageTitle()
	{
		return driver.getTitle();
	}
	
	public CreateProjectStepOnePage clickCreateNewProject() throws IOException
	{
		createNewProject.click();
		return new CreateProjectStepOnePage();				
	}
	
	public String checkAddedProject()
	{
		String myProject=myAddedProject.getText();
		return myProject;		
	}
 

}
