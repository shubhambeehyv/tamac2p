package com.mkyong.common.CallLogH;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;
@Entity
@Table
public class CallLog extends CouchEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String CALL_TYPE_UNAUTHENTICATED = "Unauthenticated";
    public static final String CALL_TYPE_AUTHENTICATED = "Authenticated";
    private String patientDocumentId;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime startTime;
    private DateTime endTime;
    private String phoneNumber;

    private String callId;
    private String callDirection;
    private String likelyPatientIds; 
    @OneToMany(cascade = CascadeType.ALL)
    private List<CallEvent> callEvents = new ArrayList<CallEvent>();

    public enum CallLogType { Answered, Missed }

   
    private String callLanguage;

    
    private String clinicId;

    
    private String patientId;

    public CallLog() {
    }
    public String getPatientDocumentId() {
		return patientDocumentId;
	}

	public void setPatientDocumentId(String patientDocumentId) {
		this.patientDocumentId = patientDocumentId;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public String getCallDirection() {
		return callDirection;
	}

	public void setCallDirection(String callDirection) {
		this.callDirection = callDirection;
	}

	public String getLikelyPatientIds() {
		return likelyPatientIds;
	}

	public void setLikelyPatientIds(String likelyPatientIds) {
		this.likelyPatientIds = likelyPatientIds;
	}

	public List<CallEvent> getCallEvents() {
		return callEvents;
	}

	public void setCallEvents(List<CallEvent> callEvents) {
		this.callEvents = callEvents;
	}

	public String getCallLanguage() {
		return callLanguage;
	}

	public void setCallLanguage(String callLanguage) {
		this.callLanguage = callLanguage;
	}

	public String getClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	
}