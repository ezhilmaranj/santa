package com.logica.srtracker.error;

import java.io.Serializable;

public class Errors implements Serializable {
	private static final long serialVersionUID = 3875631127302523938L;
	public static final String SYSTEM_ERROR_CODE_900 = "900";
	public static final String SYSTEM_ERROR_TEXT_900 = "Please Start The DataBase...!";
	public static final String SYSTEM_ERROR_CODE_901 = "901";
	public static final String SYSTEM_ERROR_TEXT_901 = "Sorry!.No matching record found.";
	public static final String SYSTEM_ERROR_CODE_902 = "902";
	public static final String SYSTEM_ERROR_TEXT_902 = "Sorry!.Error while accessing database.";
	public static final String SYSTEM_ERROR_CODE_903 = "903";
	public static final String SYSTEM_ERROR_TEXT_903 = "Sorry! Input Values null..";
	private String errCode;
	private String errDesc;

	public Errors() {
		super();
	}

	public Errors(String errCode, String errDesc) {
		super();
		this.errCode = errCode;
		this.errDesc = errDesc;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	@Override
	public String toString() {
		return "Errors [errCode=" + errCode + ", errDesc=" + errDesc + "]";
	}
}
