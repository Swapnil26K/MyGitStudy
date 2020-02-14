package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acmt.setUp.SetUp;

public class A_Home extends SetUp{
	
	@FindBy(xpath="//a[@id='nav_item_Taxonomies']")
	WebElement taxonomies;
	
	@FindBy(xpath="//a[@id='nav_item_Projects']")
	WebElement projects;
	
	public A_Home() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void waitForElement()
	{
		@SuppressWarnings("deprecation")
		WebDriverWait waitForTaxonomy=new WebDriverWait(driver, 20);
		waitForTaxonomy.until(ExpectedConditions.elementToBeClickable(taxonomies));
	}

	public String verifyAcmtHomePageTitle()
	{
		String acmtHomePageTitle=driver.getTitle();
		System.out.println(acmtHomePageTitle);
		return acmtHomePageTitle;	
	}
	
	public TaxonomiesPage clickTaxonomies() throws IOException
	{
		taxonomies.click();
		return new TaxonomiesPage();
	}
	
	public ProjectsPage clickProjects() throws IOException
	{
		projects.click();
		return new ProjectsPage();
	}

}
