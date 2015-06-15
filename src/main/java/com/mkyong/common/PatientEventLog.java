package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class PatientEventLog extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    protected String patientId;

    @NotNull
    private String event;

    @NotNull
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime date;

    private String existingValue;

    public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public String getExistingValue() {
		return existingValue;
	}

	public void setExistingValue(String existingValue) {
		this.existingValue = existingValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	private String newValue;

    public PatientEventLog() {
    }
}