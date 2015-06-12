package com.mkyong.common;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.motechproject.tama.common.domain.BaseEntity;

@Entity
@Table
public class HIVMedicalHistory extends BaseEntity {

	@GeneratedValue
	@Id
	private Integer id; 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade = {CascadeType.ALL})
    private HIVTestReason testReason;
    private String testReasonId;
    @ManyToOne(cascade = {CascadeType.ALL})
    private ModeOfTransmission modeOfTransmission;
    private String modeOfTransmissionId;

    
    public HIVTestReason getTestReason() {
        return testReason;
    }

    public void setTestReason(HIVTestReason testReason) {
        this.testReason = testReason;
        this.testReasonId = testReason.getId();
    }

    public String getTestReasonId() {
        return testReasonId;
    }

    public void setTestReasonId(String testReasonId) {
        this.testReasonId = testReasonId;
    }

    
    public ModeOfTransmission getModeOfTransmission() {
        return modeOfTransmission;
    }

    public void setModeOfTransmission(ModeOfTransmission modeOfTransmission) {
        this.modeOfTransmission = modeOfTransmission;
        this.modeOfTransmissionId = modeOfTransmission.getId();
    }

    public String getModeOfTransmissionId() {
        return modeOfTransmissionId;
    }

    public void setModeOfTransmissionId(String modeOfTransmissionId) {
        this.modeOfTransmissionId = modeOfTransmissionId;
    }
}
