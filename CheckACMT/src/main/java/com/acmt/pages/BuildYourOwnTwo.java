package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acmt.setUp.SetUp;

public class BuildYourOwnTwo extends SetUp{
	
	public static String taxonomy="My States TestNg Standards";
	
	@FindBy(xpath="//p[contains(text(),'Step 2 of 3')]")
	WebElement header;
	
	@FindBy(xpath="//input[@id='documentName']")
	WebElement taxonomyName;
	
	@FindBy(xpath="//button[contains(text(),'Click here ')]")
	WebElement fileUploader;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	WebElement continueButton;
	
	@FindBy(xpath="//select[@id='importType0']")
	WebElement selectImportType;
	
	@FindBy(xpath="//button[text()='Upload']")
	WebElement uploadButton;
	
	public BuildYourOwnTwo() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void waitForElement()
	{
		@SuppressWarnings("deprecation")
		WebDriverWait waitForTaxonomy=new WebDriverWait(driver, 20);
		waitForTaxonomy.until(ExpectedConditions.elementToBeClickable(header));
	}
	
	public String verifyBuildYourOwnPage()
	{
		String buildYourOwnPage=header.getText();		
		return buildYourOwnPage;	
	}
	
	public BuildYourOwnThree nameTheTaxonomy() throws IOException, InterruptedException
	{
		/*
		 * Actions action=new Actions(driver); action.sendKeys(taxonomyName, taxonomy);
		 * action.build().perform();
		 */
		taxonomyName.sendKeys(taxonomy);//Commented on 19th September		
		//fileUploader.click();  //19th September - File Upload Code
		//Runtime.getRuntime().exec("D:\\Swapnil - Eclipse Work Space\\File Uploader Script\\FileUpload.exe"); //19th September - File Upload Code			
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		
		continueButton.click();
		return new BuildYourOwnThree();	
	}
	
	public BuildYourOwnThree uploadFile() throws IOException
	{
		fileUploader.click();
		Runtime.getRuntime().exec("D:\\Swapnil - Eclipse Work Space\\File Uploader Script\\FileUpload.exe");
		Select select=new Select(selectImportType);
		select.selectByVisibleText("Create a copy");
		uploadButton.click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		return new BuildYourOwnThree();	
	}
	

}
