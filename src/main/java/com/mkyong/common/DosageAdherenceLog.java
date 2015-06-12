package com.mkyong.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;

@Table
@Entity
public class DosageAdherenceLog extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String patientId;

    private String regimenId;

    private String dosageId;

    private Date dosageDate;

    private String dosageStatus;

    private String reason;

    private boolean dosageTakenLate;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime dosageStatusUpdatedAt;

    private String treatmentAdviceId;

    private String dosageTime;

    private DosageAdherenceLog(){
    	
    }

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getRegimenId() {
		return regimenId;
	}

	public void setRegimenId(String regimenId) {
		this.regimenId = regimenId;
	}

	public String getDosageId() {
		return dosageId;
	}

	public void setDosageId(String dosageId) {
		this.dosageId = dosageId;
	}

	public Date getDosageDate() {
		return dosageDate;
	}

	public void setDosageDate(Date dosageDate) {
		this.dosageDate = dosageDate;
	}

	public String getDosageStatus() {
		return dosageStatus;
	}

	public void setDosageStatus(String dosageStatus) {
		this.dosageStatus = dosageStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isDosageTakenLate() {
		return dosageTakenLate;
	}

	public void setDosageTakenLate(boolean dosageTakenLate) {
		this.dosageTakenLate = dosageTakenLate;
	}

	public DateTime getDosageStatusUpdatedAt() {
		return dosageStatusUpdatedAt;
	}

	public void setDosageStatusUpdatedAt(DateTime dosageStatusUpdatedAt) {
		this.dosageStatusUpdatedAt = dosageStatusUpdatedAt;
	}

	public String getTreatmentAdviceId() {
		return treatmentAdviceId;
	}

	public void setTreatmentAdviceId(String treatmentAdviceId) {
		this.treatmentAdviceId = treatmentAdviceId;
	}

	public String getDosageTime() {
		return dosageTime;
	}

	public void setDosageTime(String dosageTime) {
		this.dosageTime = dosageTime;
	}

   
}
