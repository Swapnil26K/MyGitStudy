package com.frost.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frost.setUp.SetUp;

public class FrostMetadataPage extends SetUp
{
	@FindBy(xpath="(//button[text()='Import'])[1]")
	WebElement importBtn;
	
	@FindBy(xpath="//div[@class='buttonTab']//button[text()='URL']")
	WebElement urlLink;
	
	@FindBy(xpath="//div[@id='s2id_autogen1']//a[@class='select2-choice']")
	WebElement selectCaseServer;
	
	@FindBy(xpath="//div[text()='https://comet-stg.learningmate.com/server/api/v1/CCA01/ims/case/v1p0']")
	WebElement selectServerName;
	
	@FindBy(xpath="//select[@id='caseserverTaxonomySelected']")
	WebElement selectTaxonomy;
	
	@FindBy(xpath="(//button[text()='Import'])[3]")
	WebElement importTaxonomyBtn;
	
	public FrostMetadataPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * public void clickImportButton() { importBtn.click(); }
	 * 
	 * public void clickUrl() { urlLink.click(); }
	 */
	
	public void selectCaseServer()
	{
		importBtn.click();
		urlLink.click();
		selectCaseServer.click();
		selectServerName.click();
	}
	
	public void selectTaxonomy() throws InterruptedException
	{
		Select myTaxonomy=new Select(selectTaxonomy);
		myTaxonomy.selectByVisibleText("My States Vamsi Standards");
		importTaxonomyBtn.click();
	}
}
