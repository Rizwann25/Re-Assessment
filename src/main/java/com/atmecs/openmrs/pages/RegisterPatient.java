package com.atmecs.openmrs.pages;

import com.atmecs.openmrs.testsuit.TestBase;
import com.atmecs.openmrs.utils.CommonUtils;
import com.atmecs.openmrs.utils.LogReporter;

  public class RegisterPatient extends TestBase{
	
	LogReporter logReporter=new LogReporter();
	CommonUtils commonUtils = new CommonUtils();
	
	public static String patientOneID=null;
	public static String patientTwoID=null;
	  
	  public void registerPatientOne() {
		
		commonUtils.clickElement(props.getValue("RegisterPatient"));
		commonUtils.sendkeys(props.getValue("GivenName"), props.getValue("Name_1"));
		commonUtils.sendkeys(props.getValue("FamilyName"), props.getValue("FamilyName_1"));
		commonUtils.clickElement(props.getValue("NextButton"));
		commonUtils.selectDropdown(props.getValue("GenderDropDown"),props.getValue("Gender_1"));
		commonUtils.clickElement(props.getValue("NextButton"));

		commonUtils.sendkeys(props.getValue("Day"), props.getValue("DayText_1"));
		commonUtils.sendkeys(props.getValue("Year"), props.getValue("YearText_1"));
		commonUtils.selectDropdown(props.getValue("Month"),props.getValue("MonthText_1"));
		commonUtils.clickElement(props.getValue("NextButton"));
		
		commonUtils.sendkeys(props.getValue("Address1"), props.getValue("Address1Text_1"));
		commonUtils.sendkeys(props.getValue("Address2"), props.getValue("Address2Text_1"));
		commonUtils.sendkeys(props.getValue("CityVillage"), props.getValue("City_1"));
		commonUtils.sendkeys(props.getValue("StateProvince"), props.getValue("State_1"));
		commonUtils.sendkeys(props.getValue("Country"), props.getValue("CountryText_1"));
		commonUtils.sendkeys(props.getValue("PostalCode"), props.getValue("PostalCodeText_1"));
		commonUtils.clickElement(props.getValue("NextButton"));
		
		commonUtils.sendkeys(props.getValue("PhoneNumber"), props.getValue("PhoneNo_1"));
		commonUtils.clickElement(props.getValue("NextButton"));		
		
		commonUtils.selectDropdown(props.getValue("RelationshipType"),props.getValue("Relative_1"));
		commonUtils.sendkeys(props.getValue("PersonName"), props.getValue("PersonName_1"));
		commonUtils.clickElement(props.getValue("NextButton"));
		commonUtils.clickElement(props.getValue("ConfirmButton"));
	}
	
	 public void searchAndValidateRegisteredPatients() {
		
		patientOneID= commonUtils.elementGetText(props.getValue("GetRegisteredPatientID"));
		System.out.println("patient one id=>"+patientOneID);
		commonUtils.clickElement(props.getValue("HomeLink"));
		commonUtils.clickElement(props.getValue("FindPatientRecord"));
		commonUtils.verifyMsg(commonUtils.elementGetText(props.getValue("FindpatientTitle")),props.getValue("FindPatientPageTitle"), "FindPatientPageTitleAssertion");
		commonUtils.sendkeys(props.getValue("SearchPatient"), patientOneID);
		commonUtils.isDisplayed(commonUtils.DynamicXpath(props.getValue("PName")),"PatientName");
		commonUtils.isDisplayed(commonUtils.DynamicXpath(props.getValue("Gender_RegPatient")),"Gender");
		commonUtils.isDisplayed(commonUtils.DynamicXpath(props.getValue("Age_RegPatient")),"Age");
		commonUtils.isDisplayed(commonUtils.DynamicXpath(props.getValue("DOB_RegPatient")),"DOB");
		commonUtils.clickElement(props.getValue("HomeLink"));	
	}
	
      public void registerPatientTwo() {
		
		commonUtils.clickElement(props.getValue("RegisterPatient"));
		commonUtils.sendkeys(props.getValue("GivenName"), props.getValue("Name_2"));
		commonUtils.sendkeys(props.getValue("FamilyName"), props.getValue("FamilyName_2"));
		commonUtils.clickElement(props.getValue("NextButton"));
		commonUtils.selectDropdown(props.getValue("GenderDropDown"),props.getValue("Gender_2"));
		commonUtils.clickElement(props.getValue("NextButton"));

		commonUtils.sendkeys(props.getValue("Day"), props.getValue("DayText_2"));
		commonUtils.sendkeys(props.getValue("Year"), props.getValue("YearText_2"));
		commonUtils.selectDropdown(props.getValue("Month"),props.getValue("MonthText_2"));
		commonUtils.clickElement(props.getValue("NextButton"));
		
		commonUtils.sendkeys(props.getValue("Address1"), props.getValue("Address1Text_2"));
		commonUtils.sendkeys(props.getValue("Address2"), props.getValue("Address2Text_2"));
		commonUtils.sendkeys(props.getValue("CityVillage"), props.getValue("City_2"));
		commonUtils.sendkeys(props.getValue("StateProvince"), props.getValue("State_2"));
		commonUtils.sendkeys(props.getValue("Country"), props.getValue("CountryText_2"));
		commonUtils.sendkeys(props.getValue("PostalCode"), props.getValue("PostalCodeText_2"));
		commonUtils.clickElement(props.getValue("NextButton"));
		
		commonUtils.sendkeys(props.getValue("PhoneNumber"), props.getValue("PhoneNo_2"));
		commonUtils.clickElement(props.getValue("NextButton"));		
		
		commonUtils.selectDropdown(props.getValue("RelationshipType"),props.getValue("Relative_2"));
		commonUtils.sendkeys(props.getValue("PersonName"), props.getValue("PersonName_2"));
		commonUtils.clickElement(props.getValue("NextButton"));
		commonUtils.clickElement(props.getValue("ConfirmButton"));
		patientTwoID= commonUtils.elementGetText(props.getValue("GetRegisteredPatientID"));
		System.out.println("patient two id=>"+patientTwoID);
		commonUtils.clickElement(props.getValue("HomeLink"));
	}

  public void mergePatientData() {
	System.out.println(patientOneID+" "+patientTwoID+" in mergepatientData");
	commonUtils.clickElement(props.getValue("DataManagement"));
	commonUtils.clickElement(props.getValue("MergePatientElectronicRecord"));	
	commonUtils.sendkeys(props.getValue("SearchPatient"), patientOneID);
	commonUtils.clickElement(commonUtils.DynamicXpath(patientOneID));	
	commonUtils.sendkeys(props.getValue("SearchPatient"), patientTwoID);
	commonUtils.clickElement(commonUtils.DynamicXpath(patientTwoID));	
	commonUtils.clickElement(props.getValue("ContinueBtn"));	
   }
	

}
