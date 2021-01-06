package com.atmecs.openmrs.pages;

import com.atmecs.openmrs.testsuit.TestBase;
import com.atmecs.openmrs.utils.CommonUtils;
import com.atmecs.openmrs.utils.LogReporter;

   public class LoginPage extends TestBase {
	
	LogReporter logReporter=new LogReporter();
	CommonUtils commonUtils = new CommonUtils();
	
	public void loginActions() {
		
		commonUtils.sendkeys(props.getValue("LoginUsername"),props.getValue("UserName_Input"));
		commonUtils.sendkeys(props.getValue("LoginPassword"),props.getValue("Password_Input"));
		commonUtils.clickElement(props.getValue("Pharmacy"));
		commonUtils.clickElement(props.getValue("LoginButton"));				
	}
	
	public void validateTheHomePageTitle() {
		
		String HomePageTitle = driver.getTitle();
		commonUtils.verifyMsg(HomePageTitle,props.getValue("HomePageTitle"),"HomePageTitleAssertion");
	}
	
	public void logOut() {
		commonUtils.clickElement(props.getValue("LogOutButton"));
		commonUtils.verifyMsg(commonUtils.elementGetText(props.getValue("LoginPageTitle")),
				props.getValue("LoginPageText"), "LoginPageTitleAssertion");				
	}
	
	public void searchAndValidatePatients() {
		
		commonUtils.clickElement(props.getValue("FindPatientRecord"));
		commonUtils.verifyMsg(commonUtils.elementGetText(props.getValue("FindpatientTitle")),props.getValue("FindPatientPageTitle"), "FindPatientPageTitleAssertion");
		commonUtils.sendkeys(props.getValue("SearchPatient"), props.getValue("PatientID"));
		commonUtils.isDisplayed(commonUtils.DynamicXpath(props.getValue("PatientName")),"PatientName");
		commonUtils.isDisplayed(commonUtils.DynamicXpath(props.getValue("Gender")),"Gender");
		commonUtils.isDisplayed(commonUtils.DynamicXpath(props.getValue("Age")),"Age");
		commonUtils.isDisplayed(commonUtils.DynamicXpath(props.getValue("BirthDate")),"PatientName");
		
	}	
}

