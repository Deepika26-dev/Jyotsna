package com.Mohs10.Base;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile
{
	public static String getValueForKey(String key) throws Throwable
	{
		Properties config = new Properties();
		config.load(new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Jyotsna-Mohs10\\src\\main\\resources\\Config.properties"));
		return config.getProperty(key);
	}
}
