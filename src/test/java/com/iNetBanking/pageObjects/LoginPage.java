package com.iNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	public void setUserName(String uName)
	{
		txtUserName.sendKeys(uName);
	}
	
	public void setPassWord(String pWord)
	{
		txtPassword.sendKeys(pWord);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	

}
