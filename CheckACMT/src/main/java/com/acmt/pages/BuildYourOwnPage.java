package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acmt.setUp.SetUp;

public class BuildYourOwnPage extends SetUp{
	
	@FindBy(xpath="//p[contains(text(),'Step 1 of 3')]")
	WebElement header;

	@FindBy(xpath="//button[contains(text(),' Build your own')]")
	WebElement buildYourOwnBox;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	WebElement continueButton;
	
	public BuildYourOwnPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void waitForElement()
	{
		@SuppressWarnings("deprecation")
		WebDriverWait waitForTaxonomy=new WebDriverWait(driver, 20);
		waitForTaxonomy.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p[contains(text(),'Step 1 of 3')]"))));
	}
	
	public String verifyBuildYourOwnPage()
	{
		String buildYourOwnPage=header.getText();		
		return buildYourOwnPage;	
	}
	
	public BuildYourOwnTwo clickBuildYourOwnBox() throws IOException
	{
		buildYourOwnBox.click();//Commented on 19th September
		continueButton.click();
		return new BuildYourOwnTwo();
	}
	
	public BuildYourOwnTwo importFile() throws IOException
	{
		continueButton.click();
		return new BuildYourOwnTwo();		
	}
}
