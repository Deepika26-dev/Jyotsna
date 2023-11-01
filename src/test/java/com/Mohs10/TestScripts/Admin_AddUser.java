package com.Mohs10.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Mohs10.Base.StartBrowser;
import com.Mohs10.Base.XLUtils;
import com.Mohs10.Functions.CommonFuns;
import com.Mohs10.OR.JyotsnaPageobjects;

public class Admin_AddUser extends StartBrowser {
	String excelfile = "C:\\Users\\Dell\\eclipse-workspace\\Jyotsna-Mohs10\\TestData\\JyotsnaTsdata.xlsx";
	String excelsheet = "Admin-adduser";

	@Test
	public void Admin_adduserTest() throws Throwable {
		CommonFuns hm1 = new CommonFuns();

		By roledrop = JyotsnaPageobjects.admindroprole;

			String adminid = XLUtils.getStringCellData(excelfile, excelsheet, 1, 0);
			String adminpass = XLUtils.getStringCellData(excelfile, excelsheet, 1, 1);
			String usrname = XLUtils.getStringCellData(excelfile, excelsheet, 1, 2);
			String usrlocation = XLUtils.getStringCellData(excelfile, excelsheet,1, 3);
			String useremail = XLUtils.getStringCellData(excelfile, excelsheet, 1, 4);
			String userpwd = XLUtils.getStringCellData(excelfile, excelsheet, 1, 5);
			
			hm1.Admin_Adduser(adminid, adminpass, usrname, usrlocation, useremail, userpwd, roledrop); 

		//	hm1.logout();
			Thread.sleep(5000);
		}
	}