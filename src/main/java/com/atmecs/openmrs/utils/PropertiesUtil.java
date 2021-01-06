package com.atmecs.openmrs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.atmecs.openmrs.constants.Constants;

  public class PropertiesUtil {

	private static PropertiesUtil propReader;
	private Properties prop;

	// loads all files
	private PropertiesUtil() {
		List<String> propsFiles = Arrays.asList(Constants.RegisterPatient_LOCATOR_PATH,
				Constants.DataManagement_LOCATOR_PATH, Constants.FindPatientRecord_LOCATOR_PATH,
				Constants.HOME_LOCATOR_PATH, Constants.Login_LOCATOR_PATH, Constants.TestData_path,
				Constants.Config_path);
		prop = new Properties();

		for (String filePath : propsFiles) {
			try {
				prop.load(new FileInputStream(new File(filePath)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PropertiesUtil getInstance() {
		if (propReader == null)
			propReader = new PropertiesUtil();
		return propReader;
	}

	public String getValue(String key) {
		return prop.getProperty(key);
	}

}
