package com.atmecs.openmrs.constants;

public enum ErrorMessages {
	
	TEXTNOTFOUND("TEXTNOTFOUND"), ELEMENTNOTFOUND("ELEMENTNOTFOUND"),DROPDOWNNOTFOUND("DROPDOWNNOTFOUND"),
	ELMENTNOTCLICKABLE("ELMENTNOTCLICKABLE");
	
	String value;

	private ErrorMessages(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
