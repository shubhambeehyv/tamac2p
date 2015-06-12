package com.mkyong.extras;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.motechproject.model.Time;
@Entity
@Table
public class TimeOfDay extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer hour;

    private Integer minute;

    
    private String  timeMeridiem;

    public TimeOfDay() {
    }

    public TimeOfDay(Integer hour, Integer minute, String timeMeridiem) {
        this.hour = hour;
        this.minute = minute;
        this.timeMeridiem = timeMeridiem;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getTimeMeridiem() {
        return timeMeridiem;
    }

    public void setTimeMeridiem(String timeMeridiem) {
        this.timeMeridiem = timeMeridiem;
    }

    
    public String getTimeOfDayAsString() {
        if (hour == null || minute == null) return null;
        return String.format("%02d:%02d", hour, minute);
    }

    public void setTimeOfDayAsString(String timeOfDayAsString) {
        if (StringUtils.isEmpty(timeOfDayAsString)) return;
        String[] hourMinuteArray = timeOfDayAsString.split(":");
        setHour(Integer.parseInt(hourMinuteArray[0]));
        setMinute(Integer.parseInt(hourMinuteArray[1]));
    }

    public Time toTime() {
        if (hour == null || minute == null || timeMeridiem == null) return null;
        Integer hour = getHour();
        if (hour == 12 && timeMeridiem.equals(TimeMeridiem.AM))
            hour = 0;
        else if (hour != 12 && timeMeridiem.equals(TimeMeridiem.PM))
            hour = (hour + 12) % 24;
        return new Time(hour, getMinute());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeOfDay timeOfDay = (TimeOfDay) o;

        if (hour != null ? !hour.equals(timeOfDay.hour) : timeOfDay.hour != null) return false;
        if (minute != null ? !minute.equals(timeOfDay.minute) : timeOfDay.minute != null) return false;
        if (timeMeridiem != timeOfDay.timeMeridiem) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hour != null ? hour.hashCode() : 0;
        result = 31 * result + (minute != null ? minute.hashCode() : 0);
        result = 31 * result + (timeMeridiem != null ? timeMeridiem.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if (getTimeOfDayAsString() == null) return "";
        return String.format("%s %s", getTimeOfDayAsString(), getTimeMeridiem());
    }
}
