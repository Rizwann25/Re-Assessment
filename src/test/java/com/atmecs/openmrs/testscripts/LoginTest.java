package com.atmecs.openmrs.testscripts;

import org.testng.annotations.Test;

import com.atmecs.openmrs.pages.LoginPage;
import com.atmecs.openmrs.testsuit.TestBase;

   public class LoginTest extends TestBase {
		
	LoginPage loginPage =new LoginPage();	
	
	@Test
    public void validateAllTheDetailsOfthePatient() {
	loginPage.loginActions();
	loginPage.validateTheHomePageTitle();
	loginPage.searchAndValidatePatients();
	loginPage.logOut();
					
	}	
}
