package com.Mohs10.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Mohs10.Base.StartBrowser;
import com.Mohs10.Base.XLUtils;
import com.Mohs10.Functions.CommonFuns;
import com.Mohs10.OR.JyotsnaPageobjects;

public class Super_AddAdmin extends StartBrowser {
	String excelfile = "C:\\Users\\Dell\\eclipse-workspace\\Jyotsna-Mohs10\\TestData\\JyotsnaTsdata.xlsx";
	String excelsheet = "AddAdmin";

	@Test
	public void AddAdminTest() throws Throwable {
		CommonFuns hm1 = new CommonFuns();

		By locationBoxLocator = JyotsnaPageobjects.locationbox;
		//int rowCount = XLUtils.getRowCount(excelfile, excelsheet);

		// Start a for loop to iterate through rows of data
		
			String semail = XLUtils.getStringCellData(excelfile, excelsheet, 1, 0);
			String spwd = XLUtils.getStringCellData(excelfile, excelsheet, 1, 1);
			String name = XLUtils.getStringCellData(excelfile, excelsheet, 1, 2);
			String email = XLUtils.getStringCellData(excelfile, excelsheet, 1, 3);
			String pwd = XLUtils.getStringCellData(excelfile, excelsheet, 1, 4);

			hm1.AddAdmin(semail, spwd, name, locationBoxLocator, email, pwd); 
			//hm1.logout();
			Thread.sleep(5000);

			// Add an assertion to verify if the action was successful
//            String currentUrl = driver.getCurrentUrl();
//            String expectedUrl = "http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/superadmin/Success";            
//            Assert.assertEquals(currentUrl, expectedUrl, "URLs do not match");

		}
	}
