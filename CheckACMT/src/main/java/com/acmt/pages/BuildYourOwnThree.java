package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acmt.setUp.SetUp;
import com.acmt.utilities.Xls_Reader;

public class BuildYourOwnThree extends SetUp{
	
	Xls_Reader reader=new Xls_Reader("C:\\Users\\swapnil.kadale\\Documents\\My Practice Book.xlsx");
	
	@FindBy(xpath="//button[contains(text(),'Reorder')]")
	WebElement header;
	
	@FindBy(xpath="//span[@role='textbox']")
	WebElement myElement;
	
	@FindBy(xpath="(//span[@class='controls'])[1]")
	WebElement nodes;
	
	@FindBy(xpath="(//img[@alt='Close'])[1]")
	WebElement closeButton;	
	
	@FindBy(xpath="(//span[@role='textbox' and @class='human-code ng-star-inserted'])[1]")
	WebElement humanCodingTextbox;
	
	@FindBy(xpath="//button[text()='Finish']")
	WebElement finishButton;
	
	public BuildYourOwnThree() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElement()
	{
		@SuppressWarnings("deprecation")
		WebDriverWait waitForTaxonomy=new WebDriverWait(driver, 20);
		waitForTaxonomy.until(ExpectedConditions.visibilityOf(header));
	}
	
	public String verifyBuildYourOwnPage()
	{
		System.out.println("In verification method");		
		String buildYourOwnPage=myElement.getText();		
		return buildYourOwnPage;	
	}
	
	public void addNodes()
	{
		int rowCount=reader.getRowCount("Sheet1");
		for(int i=0;i<rowCount;i++)
		{
			nodes.click();			
		}
		
		for(int i=1;i<5;i++)
		{
			WebElement humanCoding=driver.findElement(By.xpath("(//span[@role='textbox' and @class='human-code ng-star-inserted'])["+i+"]"));
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(humanCoding));
			humanCoding.sendKeys("abcd");
			
			WebElement fullStatement=driver.findElement(By.xpath("(//span[@role='textbox' and @class='full-statement ng-star-inserted'])["+i+"]"));
			wait.until(ExpectedConditions.elementToBeClickable(fullStatement));
			fullStatement.sendKeys("abcd");
		}
	}
	
	public void verifyCreatedTaxonomy() throws IOException
	{
		closeButton.click();
		//return new TaxonomiesPage();
	}

	public void finishImportingTaxonomy() throws IOException
	{
		WebDriverWait waitForTaxonomy=new WebDriverWait(driver, 20);
		waitForTaxonomy.until(ExpectedConditions.visibilityOf(finishButton));
		finishButton.click();
		//return new TaxonomiesPage();
	}
}
