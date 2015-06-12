package com.mkyong.common;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.motechproject.tama.common.TAMAConstants;
import org.motechproject.tama.common.TAMAMessages;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class MonitoringAgent extends CouchEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private String name;
	@NotNull
	@Pattern(regexp = TAMAConstants.MOBILE_NUMBER_REGEX, message = TAMAMessages.MOBILE_NUMBER_REGEX_MESSAGE)
	private String contactNumber;



	public MonitoringAgent() {

	}

	public MonitoringAgent(String id) {
		super();
		this.setId(id);
	}

	public static MonitoringAgent newMonitoringAgent() {
		return new MonitoringAgent();
	}

	public static MonitoringAgent newMonitoringAgent(String name) {
		MonitoringAgent monitoringAgent = new MonitoringAgent();
		monitoringAgent.setName(name);
		return monitoringAgent;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	

}
