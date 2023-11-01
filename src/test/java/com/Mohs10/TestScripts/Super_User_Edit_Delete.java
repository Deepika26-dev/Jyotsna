package com.Mohs10.TestScripts;

import org.testng.annotations.Test;

import com.Mohs10.Base.ScreenRecorderUtil;
import com.Mohs10.Base.StartBrowser;
import com.Mohs10.Base.XLUtils;
import com.Mohs10.Functions.CommonFuns;

public class Super_User_Edit_Delete extends StartBrowser {
	String excelfile = "C:\\Users\\Dell\\eclipse-workspace\\Jyotsna-Mohs10\\TestData\\JyotsnaTsdata.xlsx";
	String excelsheet = "SuperUser";

	@Test
	public void User_Edit_Delete() throws Throwable {
		ScreenRecorderUtil.startRecord("Test");
		CommonFuns hm1 = new CommonFuns();

		String Email = XLUtils.getStringCellData(excelfile, excelsheet, 1, 0);
		String Pwd = XLUtils.getStringCellData(excelfile, excelsheet, 1, 1);
		String eedit = XLUtils.getStringCellData(excelfile, excelsheet, 1, 2);

		hm1.User_Edit_Delete(Email, Pwd, eedit); 
		Thread.sleep(5000);
		hm1.logout();
		
		ScreenRecorderUtil.stopRecord();
	}
}
