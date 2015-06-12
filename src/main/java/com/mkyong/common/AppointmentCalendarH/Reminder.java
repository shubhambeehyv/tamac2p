package com.mkyong.common.AppointmentCalendarH;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Reminder {

	@GeneratedValue
	@Id
    private Integer id;
	
    private Date startDate;
    
    private Date endDate;
    
    private long intervalSeconds;
    
    private int repeatCount;

    public Date startDate() {
        return startDate;
    }

    public Reminder startDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date endDate() {
        return endDate;
    }

    public Reminder endDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public long intervalSeconds() {
        return intervalSeconds;
    }

    public Reminder intervalSeconds(long intervalSeconds) {
        this.intervalSeconds = intervalSeconds;
        return this;
    }

    public int repeatCount() {
        return repeatCount;
    }

    public Reminder repeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reminder reminder = (Reminder) o;

        return intervalSeconds == reminder.intervalSeconds
                && repeatCount == reminder.repeatCount
                && !(endDate != null ? !endDate.equals(reminder.endDate) : reminder.endDate != null)
                && !(startDate != null ? !startDate.equals(reminder.startDate) : reminder.startDate != null);

    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (int) (intervalSeconds ^ (intervalSeconds >>> 32));
        result = 31 * result + repeatCount;
        return result;
    }
}