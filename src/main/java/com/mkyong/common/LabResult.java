package com.mkyong.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class LabResult extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int INVALID_COUNT = -1;
    //TODO: This should not be a field
	@ManyToOne
    private LabTest labTest;

    @NotNull
    private String patientId;

    @NotNull
    private String result;

    @NotNull
    private Date testDateAsDate;

	public LabTest getLabTest() {
		return labTest;
	}

	public void setLabTest(LabTest labTest) {
		this.labTest = labTest;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getTestDateAsDate() {
		return testDateAsDate;
	}

	public void setTestDateAsDate(Date testDateAsDate) {
		this.testDateAsDate = testDateAsDate;
	}

	public static int getInvalidCount() {
		return INVALID_COUNT;
	}

   

   
    
}
