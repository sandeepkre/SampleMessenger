package org.sandy.jersy.SampleMessenger.error;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	String exception;
	String errorCode;
	String documentation;
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(String exception, String errorCode, String documentation) {
		this.exception = exception;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}
