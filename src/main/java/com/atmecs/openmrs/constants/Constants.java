package com.atmecs.openmrs.constants;

import java.io.File;

public class Constants {

	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String RESOURCES_HOME = USER_HOME + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator;

	public final static String LOCATOR_HOME = RESOURCES_HOME + "locators" + File.separator;

	public final static String Test_Data = RESOURCES_HOME + "testdata" + File.separator;

	public final static String EXCEL_HOME = RESOURCES_HOME + "exceldata" + File.separator;
	
	public final static String LOG4J_PROP_FILE=USER_HOME+"log4j.properties";


	// Excel File
	public final static String EXCEL_DATA_PATH = EXCEL_HOME + "dataFile.xlsx";
	
	// TestData Path
	public static final String Config_path = Test_Data + "config.properties";
	
	public static final String TestData_path = Test_Data + "testdata.properties";

	// Page Locators Properties File Path
	public final static String HOME_LOCATOR_PATH = LOCATOR_HOME + "homeLocators.properties";
	
	public final static String Login_LOCATOR_PATH = LOCATOR_HOME + "loginlocators.properties";
	
	public final static String FindPatientRecord_LOCATOR_PATH = LOCATOR_HOME + "findPatientRecordlocators.properties";
	
	public final static String RegisterPatient_LOCATOR_PATH = LOCATOR_HOME + "registerPatientlocators.properties";
	
	public final static String DataManagement_LOCATOR_PATH = LOCATOR_HOME + "dataMAnagementLocators.properties";

	// Chrome Driver
	public static final String Chrome_path = "./lib/chromedriver.exe";
	
	// Firefox Driver
	public static final String firefox_path = "./lib/geckodriver.exe";
	
	//Internet Explorer Driver
	public static final String IE_path = "./lib/IEDriverServer.exe";

	//Time Outs
	public final static long PAGE_LODE_TIMEOUT = 40;
	
	public final static long IMPLICIT_WAIT = 40;

}
