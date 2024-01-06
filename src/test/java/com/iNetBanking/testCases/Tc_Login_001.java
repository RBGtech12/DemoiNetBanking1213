package com.iNetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.LoginPage;

public class Tc_Login_001 extends BaseClass
{
	@Test
	public void loginTest()
	{
		driver.get(baseUrl);
		logger.info("URL is oppened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");
		
		lp.setPassWord(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("login test failed ");
		}
	}
	

}
