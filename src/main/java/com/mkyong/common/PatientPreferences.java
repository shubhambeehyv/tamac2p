package com.mkyong.common;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.BaseEntity;
import com.mkyong.extras.TimeOfDay;

@Entity
@Table
public class PatientPreferences extends BaseEntity{
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
    private Integer id;
	
	
	
	
	
    @NotNull
    protected String passcode;

    @ManyToOne(cascade = {CascadeType.ALL})
    private IVRLanguage ivrLanguage; // TODO: should probably be removed since Id is present

    private String ivrLanguageId;

    //@Enumerated(EnumType.STRING)
    private String callPreference;

    //@Enumerated(EnumType.STRING)
    private String dayOfWeeklyCall;

    @OneToOne(cascade = {CascadeType.ALL})
	private TimeOfDay bestCallTime;

    private boolean receiveOTCAdvice = false;

    private boolean activateAppointmentReminders = true;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime callPreferenceTransitionDate;

    public String getCallPreference() {
        return this.callPreference;
    }

   
    public void setCallPreference(String callPreference) {
        this.callPreference = callPreference;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

  
    public IVRLanguage getIvrLanguage() {
        return this.ivrLanguage;
    }

    public void setIvrLanguage(IVRLanguage ivrLanguage) {
        this.ivrLanguage = ivrLanguage;
        this.ivrLanguageId = ivrLanguage.getId();
    }

    public String getIvrLanguageId() {
        return ivrLanguageId;
    }

    public void setIvrLanguageId(String ivrLanguageId) {
        this.ivrLanguageId = ivrLanguageId;
    }

    public String getDayOfWeeklyCall() {
        return dayOfWeeklyCall;
    }

    public void setDayOfWeeklyCall(String dayOfWeeklyCall) {
        this.dayOfWeeklyCall = dayOfWeeklyCall;
    }

    public com.mkyong.extras.TimeOfDay getBestCallTime() {
        return bestCallTime;
    }

    public void setBestCallTime(TimeOfDay bestCallTime) {
        this.bestCallTime = bestCallTime;
    }


   

    public DateTime getCallPreferenceTransitionDate() {
        return callPreferenceTransitionDate;
    }

    public void setCallPreferenceTransitionDate(DateTime callPreferenceTransitionDate) {
        this.callPreferenceTransitionDate = callPreferenceTransitionDate;
    }

    public boolean getReceiveOTCAdvice() {
        return receiveOTCAdvice;
    }

    public void setReceiveOTCAdvice(boolean receiveOTCAdvice) {
        this.receiveOTCAdvice = receiveOTCAdvice;
    }

    public boolean getActivateAppointmentReminders() {
        return activateAppointmentReminders;
    }

    public void setActivateAppointmentReminders(boolean activateAppointmentReminders) {
        this.activateAppointmentReminders = activateAppointmentReminders;
    }
}
