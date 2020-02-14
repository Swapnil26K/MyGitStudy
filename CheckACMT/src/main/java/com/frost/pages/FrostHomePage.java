package com.frost.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frost.setUp.SetUp;

public class FrostHomePage extends SetUp
{
	@FindBy(xpath="//div[contains(text(),'Welcome Swapnil')]")
	WebElement userName;
	
	@FindBy(xpath="//a[text()='Metadata']")
	WebElement metadataLink;
	
	public FrostHomePage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public String verifyHomePageText()
	{
		String userNameText=userName.getText();
		return userNameText;		
	}
	
	public FrostMetadataPage clickMetaData() throws IOException
	{
		metadataLink.click();
		return new FrostMetadataPage();
	}

}
