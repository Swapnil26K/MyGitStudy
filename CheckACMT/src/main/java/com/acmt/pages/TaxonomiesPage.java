package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acmt.setUp.SetUp;

public class TaxonomiesPage extends SetUp {
	
	@FindBy(xpath="//button[contains(text(),'Create New Taxonomy')]")
	WebElement createNewTaxonomy;
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 tbody']//div//div")
	WebElement myAddedTaxonomy;
		
	public TaxonomiesPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String getTaxonomiesPageTitle()
	{
		String pageTitle=driver.getTitle();
		return pageTitle;		
	}
	
	public BuildYourOwnPage clickCreateNewTaxonomy() throws IOException
	{
		createNewTaxonomy.click();
		return new BuildYourOwnPage();				
	}
	
	public String checkAddedTaxonomy()
	{
		String myTax=myAddedTaxonomy.getText();
		return myTax;		
	}
	
	public InsideTaxonomy clickAddedTaxonomy() throws IOException
	{
		myAddedTaxonomy.click();
		return new InsideTaxonomy();
	}
}
