package org.dkak.carRental.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SuccessMessage {

	private String successMessage;
		
	public SuccessMessage() {
		super();
	}
	public SuccessMessage(String successMessage) {
		super();
		this.successMessage = successMessage;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
