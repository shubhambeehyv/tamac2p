package com.mkyong.common;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class WeeklyAdherenceLog extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String patientId;
    private String treatmentAdviceId;
    private Date weekStartDate;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime logDate;
    private int numberOfDaysMissed;
    private boolean notResponded;

    public WeeklyAdherenceLog() {
        notResponded = false;
    }

    public WeeklyAdherenceLog(String patientId, String treatmentAdviceDocId, Date weekStartDate, DateTime logDate, int numberOfDaysMissed) {
        this.patientId = patientId;
        this.treatmentAdviceId = treatmentAdviceDocId;
        this.weekStartDate = weekStartDate;
        this.logDate = logDate;
        this.numberOfDaysMissed = numberOfDaysMissed;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public DateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(DateTime logDate) {
        this.logDate = logDate;
    }

    public int getNumberOfDaysMissed() {
        return numberOfDaysMissed;
    }

    public void setNumberOfDaysMissed(int numberOfDaysMissed) {
        this.numberOfDaysMissed = numberOfDaysMissed;
    }

    public String getTreatmentAdviceId() {
        return treatmentAdviceId;
    }

    public void setTreatmentAdviceId(String treatmentAdviceId) {
        this.treatmentAdviceId = treatmentAdviceId;
    }

    public Date getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(Date weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

   

   
    public void setNotResponded(boolean notResponded) {
        this.notResponded = notResponded;
    }

    public boolean getNotResponded() {
        return this.notResponded;
    }

    public void merge(WeeklyAdherenceLog that) {
        this.setNotResponded(that.getNotResponded());
        this.setLogDate(that.getLogDate());
        this.setNumberOfDaysMissed(that.getNumberOfDaysMissed());
        this.setTreatmentAdviceId(that.getTreatmentAdviceId());
        this.setPatientId(that.getPatientId());
        this.setWeekStartDate(that.getWeekStartDate());
    }
}
