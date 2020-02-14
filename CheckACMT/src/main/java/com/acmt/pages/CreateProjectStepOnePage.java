package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acmt.setUp.SetUp;

public class CreateProjectStepOnePage extends SetUp {
	
	@FindBy(xpath="//p[contains(text(),'Step 1 of 2')]")
	WebElement header;
	
	@FindBy(xpath="//input[@id='projectName']")
	WebElement projectName;

	/*
	 * @FindBy(xpath="//textarea[@id='projectDescription']") WebElement
	 * projectDescription;
	 */
	
	@FindBy(xpath="(//button[contains(text(),'Select')])[1]")
	WebElement workFlow;
	
	@FindBy(xpath="(//button[contains(text(),'Select')])")
	WebElement taxonomy;
	
	@FindBy(xpath="//span[contains(text(),'Default workflow')]")
	WebElement selectedWorkflow;
	
	@FindBy(xpath="//span[contains(text(),'Natural Science')]")
	WebElement selectedTaxonomy;
	
	@FindBy(xpath="//label[contains(text(),' Natural Science ')]//preceding-sibling::input")
	WebElement checkBoxTaxonomy;
	
	@FindBy(xpath="(//button[contains(text(),'Create')])[2]")
	WebElement createButton;
	
	
	public CreateProjectStepOnePage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void waitForElement()
	{
		@SuppressWarnings("deprecation")
		WebDriverWait waitForTaxonomy=new WebDriverWait(driver, 20);
		waitForTaxonomy.until(ExpectedConditions.elementToBeClickable(header));
	}
	
	public String verifyCreateProjectStepOnePage()
	{
		String createProjectStepOnePage=header.getText();		
		return createProjectStepOnePage;	
	}
	
	public void enterProjectName() throws InterruptedException
	{
		/*
		 * WebDriverWait wait=new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.elementToBeClickable(workFlow));
		 */
		Actions action=new Actions(driver);
		action.click(projectName);
		action.sendKeys(projectName, "My Thirteenth Project").build().perform();
		//action.wait(10);
		

		//projectName.sendKeys("My Fourth Project");
		//projectDescription.sendKeys("My Third Project Description");
	}
	
	/*
	 * public void enterProjectDescription() {
	 * projectDescription.sendKeys("My Fourth Project Description"); }
	 */
	 
	
	public void selectWorkFlow()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(workFlow));
		workFlow.click();
		selectedWorkflow.click();
	}
	
	public void selectTaxonomy()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(taxonomy));
		taxonomy.click();
		selectedTaxonomy.click();
	}
	
	public void checkTaxonomy()
	{
		checkBoxTaxonomy.click();		
	}
	
	public CreateProjectStepTwoPage clickCreateButton() throws IOException
	{
		createButton.click();
		return new CreateProjectStepTwoPage();
	}
}
