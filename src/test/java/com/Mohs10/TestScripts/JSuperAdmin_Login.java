package com.Mohs10.TestScripts;

import java.util.Properties;

import org.testng.annotations.Test;

import com.Mohs10.Base.ScreenRecorderUtil;
import com.Mohs10.Base.StartBrowser;
import com.Mohs10.Base.XLUtils;
import com.Mohs10.Functions.CommonFuns;

class JSuperAdmin_Login extends StartBrowser {
	Properties prop;
	String excelfile = "C:\\Users\\Dell\\eclipse-workspace\\Jyotsna-Mohs10\\TestData\\JyotsnaTsdata.xlsx";
	String excelsheet = "LoginCreds";

	@Test(priority = 0 ,description="Login Test")
	public void LoginTestCase() throws Exception {
		ScreenRecorderUtil.startRecord("Superadmin positive LoginTest");
		CommonFuns hm1 = new CommonFuns();

		String Email = XLUtils.getStringCellData(excelfile, excelsheet, 1, 0);
		String Pwd = XLUtils.getStringCellData(excelfile, excelsheet, 1, 1);

		hm1.logIn(Email, Pwd);
		hm1.logout();
		Thread.sleep(5000);
		ScreenRecorderUtil.stopRecord();
	}
	
	@Test(priority = 1 ,description="Negative Login Test on Super admin Module")
	public void NegativeLoginTest() throws Throwable {
		ScreenRecorderUtil.startRecord("Superadmin negative LoginTest");
		CommonFuns hm2 = new CommonFuns();

		int rowcount = XLUtils.getRowCount(excelfile, excelsheet);
		for (int i = 2; i < rowcount; i++) {
			String Email = XLUtils.getStringCellData(excelfile, excelsheet, i, 0);
			String Pwd = XLUtils.getStringCellData(excelfile, excelsheet, i, 1);

			hm2.invalidLogIn(Email, Pwd);
			Thread.sleep(5000);
		}
		ScreenRecorderUtil.stopRecord();

	}
	
}