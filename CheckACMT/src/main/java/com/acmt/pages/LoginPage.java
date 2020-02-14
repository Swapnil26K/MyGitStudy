package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import com.acmt.setUp.SetUp;

public class LoginPage extends SetUp{
	
	@FindBy(id="emailID")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	WebElement loginBtn;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public String verifyLoginPageTitle()
	{
		String loginPageTitle=driver.getTitle();
		return loginPageTitle;		
	}
	
	public A_Home login() throws IOException
	{
		emailId.sendKeys("swapnil.kadale@learningmate.com");
		password.sendKeys("Gajanan@123");
		loginBtn.click();
		return new A_Home();
	}
}
