package com.mkyong.common;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.motechproject.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class MessageHistory extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String messageId;
    
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime lastPlayedOn;
    private int count;

    public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public DateTime getLastPlayedOn() {
		return lastPlayedOn;
	}

	public MessageHistory() {
    }

    public MessageHistory(String messageId) {
        this.messageId = messageId;
    }

    public void setLastPlayedOn(DateTime lastPlayedOn) {
        this.lastPlayedOn = DateUtil.setTimeZone(lastPlayedOn);
    }

    public void readOn(DateTime dateTime) {
        lastPlayedOn = dateTime;
        count++;
    }

    public boolean neverPlayed() {
        return null == lastPlayedOn;
    }
}
