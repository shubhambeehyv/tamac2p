package com.mkyong.common.AppointmentCalendarH;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table
public class Visit {

   
	@Id
	@GeneratedValue
	private Integer id;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}


	private String name;
    
    private String typeOfVisit;
    
    private DateTime visitDate;
    
    private boolean missed;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Appointment appointment;

    @OneToOne(cascade = CascadeType.ALL)
    private Reminder reminder;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeOfVisit() {
		return typeOfVisit;
	}
	public void setTypeOfVisit(String typeOfVisit) {
		this.typeOfVisit = typeOfVisit;
	}
	public DateTime getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(DateTime visitDate) {
		this.visitDate = visitDate;
	}
	public boolean isMissed() {
		return missed;
	}
	public void setMissed(boolean missed) {
		this.missed = missed;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Reminder getReminder() {
		return reminder;
	}
	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}
	
	
	@ElementCollection
	private Map<String, String> data = new HashMap<String, String>();

	public Map<String, String> getData() {
	        return data;
	  }

	public Visit addData(String key, String value) {
	        this.data.put(key, value);
	        return  this;
	   }

	public Visit addData(Map<String, String> data) {
	        for (String key : data.keySet()) {
	            this.addData(key, data.get(key));
	        }
	        return  this;
	   }
}