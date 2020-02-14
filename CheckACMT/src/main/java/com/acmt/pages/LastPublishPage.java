package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acmt.setUp.SetUp;

public class LastPublishPage extends SetUp{
	
	@FindBy(xpath="//modal-div[contains(text(),'Publish')]")
	WebElement publishHeader;	
	
	@FindBy(xpath="(//button[contains(text(),'Publish')])[2]")
	WebElement publishButton;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement yesButton;
	
	public LastPublishPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String getTitle()
	{
		String headerTitle=publishHeader.getText();
		return headerTitle;
	}
	
	public void publishIt()
	{
		publishButton.click();
		yesButton.click();
		System.out.println("Clicked Successfully");
	}

	public void waitForText()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(publishHeader));
	}
	

}
