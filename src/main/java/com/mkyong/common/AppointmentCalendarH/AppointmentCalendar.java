package com.mkyong.common.AppointmentCalendarH;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mkyong.common.MotechBaseDataObject;


@Table
@Entity
public class AppointmentCalendar extends MotechBaseDataObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String externalId;
  
	@OneToMany(cascade = CascadeType.ALL)
    private List<Visit> visits = new ArrayList<Visit>();

    public String getExternalId() {
        return externalId;
    }

    public List<Visit> visits() {
        return visits;
    }

 

    public AppointmentCalendar externalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

 

    // For ektorp

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}
