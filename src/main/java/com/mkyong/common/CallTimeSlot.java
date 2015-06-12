package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.motechproject.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;
@Table
@Entity
public class CallTimeSlot extends CouchEntity {

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
	private DateTime callTime;

    @NotNull
    @ManyToOne
    private Patient patient;

   
    public LocalTime getCallTime() {
        if (callTime == null) return null;
        return DateUtil.setTimeZone(callTime).toLocalTime();
    }

  
    public void setCallTime(LocalTime callTime) {
        this.callTime = new DateTime(0).withTime(callTime.getHourOfDay(), callTime.getMinuteOfHour(), callTime.getSecondOfMinute(), 0);
    }

    
}
