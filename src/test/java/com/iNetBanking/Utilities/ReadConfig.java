package com.iNetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;

	public ReadConfig()
	{
		File src=new File("C://Users//LENOVO//workspace//iNetBankingv2//Configuration//config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);

		}
		catch(Exception e)
		{
			System.out.println("Exception :"+ e.getMessage());
		}

	}
	public String geturl()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}

	public String getUserName()
	{
		String userName=pro.getProperty("username");
		return userName;
	}

	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
}


