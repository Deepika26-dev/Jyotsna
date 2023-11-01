package com.Mohs10.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import com.Mohs10.Base.StartBrowser;
import com.Mohs10.Base.XLUtils;
import com.Mohs10.Functions.CommonFuns;
import com.Mohs10.OR.JyotsnaPageobjects;

public class Salesforce_addContact extends StartBrowser{
	String excelfile = "C:\\Users\\Dell\\eclipse-workspace\\Jyotsna-Mohs10\\TestData\\JyotsnaTsdata.xlsx";
	String excelsheet = "sales";
	
	@Test	
	public void SalesAddContactTest() throws Throwable {
		CommonFuns hm1 = new CommonFuns();
		
			String Email = XLUtils.getStringCellData(excelfile, excelsheet, 1, 0);
			String Pwd = XLUtils.getStringCellData(excelfile, excelsheet, 1, 1);

			hm1.Salesforce_app(Email, Pwd);
			
			
			
}
}
