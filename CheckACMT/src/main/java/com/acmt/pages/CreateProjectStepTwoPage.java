package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acmt.setUp.SetUp;

public class CreateProjectStepTwoPage extends SetUp{
	
	@FindBy(xpath="//p[contains(text(),'Step 2 of 2')]")
	WebElement header;
	
	@FindBy(xpath="//button[contains(text(),'Done')]")
	WebElement doneButton;
	
	public CreateProjectStepTwoPage() throws IOException {
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
		String createProjectStepTwoPage=header.getText();		
		return createProjectStepTwoPage;	
	}
	
	public void clickDoneButton()
	{
		doneButton.click();
	}
}
