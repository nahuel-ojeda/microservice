package com.springboot.api.Transporte.util;

public class ErrorDescriptionUtil {

	public static final String E_GENERAL_EXCEPTION_CODE = "0001";
	public static final String E_GENERAL_EXCEPTION = "System Error. Check with your System Administrator.";
	
	public static final String TE_CLOB_TO_STRING_CODE = "0002";
	public static final String TE_CLOB_TO_STRING = "Error when trying to convert a data type Clob to String";

	private ErrorDescriptionUtil() {
		
	}
}
