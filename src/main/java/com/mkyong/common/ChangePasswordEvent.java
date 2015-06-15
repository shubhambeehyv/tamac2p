package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.motechproject.util.DateUtil;

@Entity
@Table
public class ChangePasswordEvent extends TAMAEvent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getClinicianName() {
		return clinicianName;
	}

	public void setClinicianName(String clinicianName) {
		this.clinicianName = clinicianName;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	String clinicianName;
    String clinicName;
    String clinicId;
    String username;

    public ChangePasswordEvent() {}

    public ChangePasswordEvent(String clinicianName, String clinicName, String clinicId, String username) {
        super(DateUtil.now());
        this.clinicianName = clinicianName;
        this.clinicName = clinicName;
        this.clinicId = clinicId;
        this.username = username;
    }
}