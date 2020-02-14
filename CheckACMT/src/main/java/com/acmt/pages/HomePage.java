package com.acmt.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acmt.setUp.SetUp;

public class HomePage extends SetUp
{
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginButton;
	
	public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomeLink()
	{
		String linkText=driver.findElement(By.xpath("//button[@id='Home-button']")).getText();
		return linkText;
	}
	
	public LoginPage clickLoginButton() throws IOException, InterruptedException
	{
		/*
		 * @SuppressWarnings("deprecation") WebDriverWait wait=new WebDriverWait(driver,
		 * 20); wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		 */
		
		loginButton.click();
		//driver.wait(30);		
		return new LoginPage();
	}
}
