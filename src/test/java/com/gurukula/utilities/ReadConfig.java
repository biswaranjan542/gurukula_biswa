package com.gurukula.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public  class ReadConfig {
	
	Properties pr;
	
	public  ReadConfig()
	{
		File src = new File("./Configuration//config.properties");
		pr = new Properties();		
		
		try
		{			
			FileInputStream fis = new FileInputStream(src);
			pr.load(fis);			
		}
		
		catch (Exception e)
		{
			System.out.println("Exception is" + e.getMessage());
		}
		
	}

	
	public String getbaseURL()
	{
		String URL = pr.getProperty("baseURL");
		return URL;
	}
	
	public String getusername()
	{
		String uname = pr.getProperty("username");
		return uname;
				
	}
	
	public String getpasswd()
	{
		String pwd = pr.getProperty("passwd");
		return pwd;
	}
	
	public String getchromepath()
	{
		String path= pr.getProperty("chromepath");
		return path;
	}
	
	public String getiepath()
	{
		return pr.getProperty("iepath");
	}
	
}
