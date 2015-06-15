package com.mkyong.common;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormatter;
import org.motechproject.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;


@Entity
@Table
public class Patient extends CouchEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String CLINIC_AND_PATIENT_ID_UNIQUE_CONSTRAINT = "Constraint:Unique:Clinic/PatientId::";
    public static final String PHONE_NUMBER_AND_PASSCODE_UNIQUE_CONSTRAINT = "Constraint:Unique:PhoneNumber/Passcode::";

   
   
    
    @Getter
    @Setter
    protected String patientId;

    //@NotNull
    
    @Getter
    @Setter
    protected String mobilePhoneNumber;

    @Temporal(TemporalType.DATE)
    
    //@NotNull
    protected Date dateOfBirthAsDate;

    @ManyToOne
    private Gender gender;

    @ManyToOne
    private Clinic clinic;

    @Getter
    @Setter
    private String genderId;
    @Getter
    @Setter
    private String clinic_id;

    @Getter
    @Setter
    private boolean complete;
    
    @Getter
    @Setter
    private String status = Status.Inactive.toString();

   

	@Valid
    @Getter
    @Setter
    @OneToOne(cascade = {CascadeType.ALL})
    private PatientPreferences patientPreferences;
    @Getter
    @Setter
    @OneToOne(cascade = {CascadeType.ALL})
    private MedicalHistory medicalHistory;
    //@Getter
    //@Setter
    //private Status status = Status.Inactive;

   
    private String notes;

   
    private int travelTimeToClinicInDays;
    
    private int travelTimeToClinicInHours;
    
    public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public int getTravelTimeToClinicInDays() {
		return travelTimeToClinicInDays;
	}


	public void setTravelTimeToClinicInDays(int travelTimeToClinicInDays) {
		this.travelTimeToClinicInDays = travelTimeToClinicInDays;
	}


	public int getTravelTimeToClinicInHours() {
		return travelTimeToClinicInHours;
	}


	public void setTravelTimeToClinicInHours(int travelTimeToClinicInHours) {
		this.travelTimeToClinicInHours = travelTimeToClinicInHours;
	}


	public int getTravelTimeToClinicInMinutes() {
		return travelTimeToClinicInMinutes;
	}


	public void setTravelTimeToClinicInMinutes(int travelTimeToClinicInMinutes) {
		this.travelTimeToClinicInMinutes = travelTimeToClinicInMinutes;
	}

	private int travelTimeToClinicInMinutes;

    private Date registrationDateAsDate;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime lastSuspendedDate;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime activationDate;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime lastDeactivationDate;
  
    
   /* public boolean allowAdherenceCalls() {
        return status.isActive();
    }

    
    public boolean allowOutboxCalls() {
        return status.isActive() || status.isSuspended();
    }

    
    public boolean allowIncomingCalls() {
        return status.isActive() || status.isSuspended();
    }*/

    
    /*public boolean isOnDailyPillReminder() {
        return callPreference().isDaily();
    }*/

    
    /*public boolean isOnWeeklyPillReminder() {
        return !isOnDailyPillReminder();
    }*/

   
    

    
    public boolean hasAgreedToReceiveOTCAdvice() {
        return this.patientPreferences.getReceiveOTCAdvice();
    }

    
   /* public CallPreference callPreference() {
        return this.patientPreferences.getCallPreference();
    }*/

    
   

    
    /*public DayOfWeek getDayOfWeeklyCall() {
        return this.patientPreferences.getDayOfWeeklyCall();
    }*/


    public String getLanguageCode() {
        return this.patientPreferences.getIvrLanguage().getCode();
    }

    public LocalDate getDateOfBirth() {
        return DateUtil.newDate(dateOfBirthAsDate);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirthAsDate = toDate(dateOfBirth);
    }

    
    public Date getDateOfBirthAsDate() {
        return dateOfBirthAsDate;
    }

    public void setDateOfBirthAsDate(Date dateOfBirth) {
        this.dateOfBirthAsDate = dateOfBirth;
    }

    
    public Date getRegistrationDateAsDate() {
        return registrationDateAsDate;
    }

    
    public String getGenderType() {
        if (this.getGender() != null) return this.getGender().getType();
        return null;
    }

    
    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
        this.genderId = gender.getId();
    }

    
    public Clinic getClinic() {
        return this.clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
        this.clinic_id = clinic.getId();
    }

  

   
    //Sets on patient creation.
    public LocalDate getRegistrationDate() {
        if (registrationDateAsDate == null) {
            this.registrationDateAsDate = toDate(DateUtil.today());
        }
        return DateUtil.newDate(registrationDateAsDate);
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if (registrationDate != null) {
            this.registrationDateAsDate = toDate(registrationDate);
        }
    }

    public DateTime getActivationDate() {
        return DateUtil.setTimeZone(activationDate);
    }

    public void setActivationDate(DateTime activationDate) {
        if (this.activationDate == null) {
            this.activationDate = activationDate;
        }
    }

    public DateTime getLastDeactivationDate() {
        return DateUtil.setTimeZone(lastDeactivationDate);
    }

    public void setLastDeactivationDate(DateTime lastDeactivationDate) {
        this.lastDeactivationDate = lastDeactivationDate;
    }

    public DateTime getLastSuspendedDate() {
        return DateUtil.setTimeZone(lastSuspendedDate);
    }

    public void setLastSuspendedDate(DateTime lastSuspendedDate) {
        this.lastSuspendedDate = lastSuspendedDate;
    }

    /*public Patient deactivate(Status status) {
        this.status = status;
        setLastDeactivationDate(DateUtil.now());
        return this;
    }

    public Patient activate() {
        this.status = Status.Active;
        setActivationDate(DateUtil.now());
        return this;
    }*/

    
    public String getDisplayableSuspendedDateAndTime() {
        DateTimeFormatter timeFormatter = org.joda.time.format.DateTimeFormat.forPattern("HH:mm");
        DateTimeFormatter dateFormatter = org.joda.time.format.DateTimeFormat.forPattern("EEE MMM dd YYYY");
        return getLastSuspendedDate() == null ? null : dateFormatter.print(getLastSuspendedDate()) + ", at " + timeFormatter.print(getLastSuspendedDate().toLocalTime());
    }

    
    public int getAge() {
        Period period = new Period(getDateOfBirth(), DateUtil.today(), PeriodType.years());
        return period.getYears();
    }

    
    /*public void suspend() {
        setStatus(Status.Suspended);
        setLastSuspendedDate(DateUtil.now());
    }*/

    
    /*public boolean canTransitionToWeekly(int minNumberOfDaysOnDailyBeforeTransitioningToWeekly) {
        if (getActivationDate() == null)
            return false;
        boolean moreThan4WeeksAfterActivation = Days.daysBetween(getActivationDate(), DateUtil.now()).getDays() >= minNumberOfDaysOnDailyBeforeTransitioningToWeekly;
        return moreThan4WeeksAfterActivation && patientPreferences.getCallPreference().isDaily();
    }*/

    /*public boolean shouldReceiveAppointmentReminder() {
        return getPatientPreferences().getActivateAppointmentReminders();
    }*/

    public boolean hasSamePatientID(String patientId) {
        return this.patientId.equals(patientId);
    }

    public boolean hasSamePatientDocumentID(String patientDocumentId) {
        return this.getId().equals(patientDocumentId);
    }

    public boolean hasSamePhoneNumber(String mobilePhoneNumber) {

        return this.mobilePhoneNumber.equals(mobilePhoneNumber);
    }

    public boolean hasSameClinicName(String clinicName) {
        return this.clinic.getName().equals(clinicName);
    }

    public boolean hasSameClinicId(String clinicId) {
        return this.clinic_id.equals(clinicId);
    }

    /*public boolean hasSameIdClinicId(String id) {
        return this.clinic.getId().equals(id);
    }*/
}


   
    
    
