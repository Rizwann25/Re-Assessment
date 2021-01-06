package com.atmecs.openmrs.utils;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.atmecs.openmrs.constants.Constants;

   public class LogReporter {
        Logger logger = null;
	
	public LogReporter() {
		getlogger();
		logger = Logger.getLogger(LogReporter.class.getName());
	}
	
	public void getlogger() {
		PropertyConfigurator.configure(Constants.LOG4J_PROP_FILE);
	}

	public void info(String message){
		logger.info(message);
	}
	
	public void debug(String message){	
	}
	
	public static void main(String[] args) {	
	    LogReporter rep=new LogReporter();
		rep.info("will");
	}
}
