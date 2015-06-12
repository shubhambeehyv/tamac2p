package com.mkyong.common;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.io.Serializable;

public class Time implements Comparable<Time>, Serializable {
    private static final long serialVersionUID = -6049964979382913093L;
    private static final int TIME_TOKEN_MIN_LENGTH = 2;
    private static final int TIME_TOKEN_MAX_LENGTH = 3;
    private Integer hour;
    private Integer minute;

    public Time() {
    }

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Time(Integer hour, Integer minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Time(LocalTime localTime) {
        this(localTime.getHourOfDay(), localTime.getMinuteOfHour());
    }

    public Time(String timeStr) {
        String[] tokens = timeStr.split(":");

        if (tokens.length < TIME_TOKEN_MIN_LENGTH || tokens.length > TIME_TOKEN_MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid time string: " + timeStr);
        }

        try {
            this.hour = Integer.parseInt(tokens[0]);
            this.minute = Integer.parseInt(tokens[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid time string: " + timeStr, e);
        }
    }

    public String timeStr() {
        return String.format("%02d:%02d", hour, minute);
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

    public boolean le(Time toCompare) {
        return (this.getHour() < toCompare.getHour() || (this.getHour().intValue() == toCompare.getHour() && this.getMinute() <= toCompare.getMinute()));
    }

    public boolean ge(Time toCompare) {
        return (this.getHour() > toCompare.getHour() || (this.getHour().intValue() == toCompare.getHour() && this.getMinute() >= toCompare.getMinute()));
    }

    public DateTime getDateTime(DateTime dateTime) {
        return new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), hour, minute, 0, 0);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hour == null) ? 0 : hour.hashCode());
        result = prime * result + ((minute == null) ? 0 : minute.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Time other = (Time) obj;
        if (hour == null) {
            if (other.hour != null) {
                return false;
            }
        } else if (!hour.equals(other.hour)) {
            return false;
        }
        if (minute == null) {
            if (other.minute != null) {
                return false;
            }
        } else if (!minute.equals(other.minute)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return timeStr();
    }

    public static Time parseTime(String time, String separator) {
        if (time == null) {
            return null;
        }
        String[] strings = StringUtils.split(time, separator);
        if (strings.length != 2) {
            throw new IllegalArgumentException();
        }
        return new Time(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
    }

    public int compareTo(Time otherTime) {
        if (otherTime.getHour().equals(this.getHour())) {
            return this.getMinute().compareTo(otherTime.getMinute());
        }
        return this.getHour().compareTo(otherTime.getHour());
    }

    public boolean isBefore(Time other) {
        return compareTo(other) < 0;
    }

    public static Time valueOf(String str) {
        return new Time(str);
    }
}