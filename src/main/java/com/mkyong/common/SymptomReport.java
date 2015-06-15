package com.mkyong.common;



import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.mkyong.extras.CouchEntity;


@Entity
@Table
public class SymptomReport extends CouchEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String symptomIds;
    
    private String patientDocId;
    
    private String callId;
    
    private String adviceGiven;
    
    private String doctorContacted;
    
    private DateTime reportedAt;

    protected SymptomReport() {
    }

    public SymptomReport(String patientDocId, String callId, DateTime reportedAt) {
        this.patientDocId = patientDocId;
        this.callId = callId;
        this.reportedAt = reportedAt;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

   

    public String getSymptomIds() {
		return symptomIds;
	}

	public void setSymptomIds(String symptomIds) {
		this.symptomIds = symptomIds;
	}

	public String getPatientDocId() {
		return patientDocId;
	}

	public void setPatientDocId(String patientDocId) {
		this.patientDocId = patientDocId;
	}

	public String getAdviceGiven() {
		return adviceGiven;
	}

	public void setAdviceGiven(String adviceGiven) {
		this.adviceGiven = adviceGiven;
	}

	
	public String getDoctorContacted() {
		return doctorContacted;
	}

	public void setDoctorContacted(String doctorContacted) {
		this.doctorContacted = doctorContacted;
	}

	public DateTime getReportedAt() {
		return reportedAt;
	}

	public void setReportedAt(DateTime reportedAt) {
		this.reportedAt = reportedAt;
	}

	@Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (symptomIds != null ? symptomIds.hashCode() : 0);
        result = 31 * result + (patientDocId != null ? patientDocId.hashCode() : 0);
        return result;
    }
}
