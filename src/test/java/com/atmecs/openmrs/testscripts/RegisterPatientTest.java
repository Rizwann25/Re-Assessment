package com.atmecs.openmrs.testscripts;

import org.testng.annotations.Test;

import com.atmecs.openmrs.pages.LoginPage;
import com.atmecs.openmrs.pages.RegisterPatient;
import com.atmecs.openmrs.testsuit.TestBase;

public class RegisterPatientTest extends TestBase {
	
	LoginPage loginPage =new LoginPage();
	RegisterPatient registerPatient = new RegisterPatient();
	
	@Test
    public void validatePatientRegistrationAndMerging() {
	loginPage.loginActions();
	registerPatient.registerPatientOne();
	registerPatient.searchAndValidateRegisteredPatients();
	registerPatient.registerPatientTwo();
	registerPatient.mergePatientData();
	}

}
