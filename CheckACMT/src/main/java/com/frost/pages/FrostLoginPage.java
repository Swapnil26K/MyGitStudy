package com.frost.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frost.setUp.SetUp;

public class FrostLoginPage extends SetUp{
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginBtn;
	
	public FrostLoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public String verifyLoginPageTitle()
	{
		String loginPageTitle=driver.getTitle();
		System.out.println(loginPageTitle);
		return loginPageTitle;		
	}
	
	public void waitForElement()
	{
		@SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));		
	}
	
	public FrostHomePage login() throws IOException
	{
		userName.sendKeys("Swapnil");
		password.sendKeys("Gajanan@123");
		loginBtn.click();
		return new FrostHomePage();
	}
}