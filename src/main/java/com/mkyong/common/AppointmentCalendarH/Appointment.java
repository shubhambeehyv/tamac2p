package com.mkyong.common.AppointmentCalendarH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table
public class Appointment  {

    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DateTime getOriginalDueDate() {
		return originalDueDate;
	}

	public void setOriginalDueDate(DateTime originalDueDate) {
		this.originalDueDate = originalDueDate;
	}

	public DateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(DateTime dueDate) {
		this.dueDate = dueDate;
	}

	public DateTime getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(DateTime confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public List<Reminder> getReminders() {
		return reminders;
	}

	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	@Id
	private String id;
    
    private DateTime originalDueDate;
    
    private DateTime dueDate;
    
    private DateTime confirmedDate;
    
    
  
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reminder> reminders = new ArrayList<Reminder>();
    

    @ElementCollection
    private Map<String, String> data = new HashMap<String, String>();

    public Map<String, String> getData() {
        return data;
    }

    public Appointment addData(String key, String value) {
        this.data.put(key, value);
        return  this;
    }

    public Appointment addData(Map<String, String> data) {
        for (String key : data.keySet()) {
            this.addData(key, data.get(key));
        }
        return  this;
    }
    }