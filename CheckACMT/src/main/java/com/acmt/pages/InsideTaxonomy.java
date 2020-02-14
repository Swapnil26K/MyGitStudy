package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acmt.setUp.SetUp;

public class InsideTaxonomy extends SetUp{
	
	@FindBy(xpath="//h1")
	WebElement myAddedTaxonomyName;
	
	@FindBy(xpath="//button[contains(text(),'publish')]")
	WebElement publishTab;
	
	@FindBy(xpath="(//button[contains(text(),'Publish')])[1]")
	WebElement publishButton;
	
	public InsideTaxonomy() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String getTaxonomyText()
	{
		String myTaxonomyName=myAddedTaxonomyName.getText();
		return myTaxonomyName;
	}
	
	public LastPublishPage clickPublishTab() throws IOException
	{
		publishTab.click();
		publishButton.click();
		return new LastPublishPage();
	}
	
	public void waitForText()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(myAddedTaxonomyName));
	}

}
