package com.Mohs10.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Mohs10.Base.StartBrowser;
import com.Mohs10.Base.XLUtils;
import com.Mohs10.Functions.CommonFuns;
import com.Mohs10.OR.JyotsnaPageobjects;

public class Receptionist_Addpatient extends StartBrowser{

	String excelfile = "C:\\Users\\Dell\\eclipse-workspace\\Jyotsna-Mohs10\\TestData\\JyotsnaTsdata.xlsx";
	String excelsheet = "Receptionist";
	
	@Test
	public void Receptionist_AddpatientTest() throws Throwable {
		CommonFuns hm1 = new CommonFuns();
		
		By gender = JyotsnaPageobjects.ptngender;
		//By dob = JyotsnaPageobjects.ptndob;
		By state = JyotsnaPageobjects.ptnstate;
		
		String Remail = XLUtils.getStringCellData(excelfile, excelsheet, 1, 0);
		String Rpwd = XLUtils.getStringCellData(excelfile, excelsheet, 1, 1);
		String pfname = XLUtils.getStringCellData(excelfile, excelsheet, 1, 2);
		String plname = XLUtils.getStringCellData(excelfile, excelsheet, 1, 3);
		//String ptndob = XLUtils.getStringCellData(excelfile, excelsheet, 1, 4);
		String ptnzipcode = XLUtils.getStringCellData(excelfile, excelsheet, 1, 5);
		String pcity = XLUtils.getStringCellData(excelfile, excelsheet, 1, 6);
		String paddress = XLUtils.getStringCellData(excelfile, excelsheet, 1, 7);
		String pphone = XLUtils.getStringCellData(excelfile, excelsheet, 1, 8);
		String pemail = XLUtils.getStringCellData(excelfile, excelsheet, 1, 9);
		
		hm1.Receptionist_AddPatient(Remail, Rpwd, pfname, plname, ptnzipcode, pcity, paddress, pphone, pemail, gender, state);
		
				
		//hm1.logout();
	}

}












