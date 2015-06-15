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
public class SMSLog extends CouchEntity {

   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recipient;
    
    public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(style="SS")
    private DateTime sentDateTime;

    public SMSLog() {
    }

    public SMSLog(String recipient, String message) {
        this.message = message;
        this.recipient = recipient;
        this.sentDateTime = DateUtil.now();
    }

    public DateTime getSentDateTime() {
        return sentDateTime;
    }

    public void setSentDateTime(DateTime sentDateTime) {
        this.sentDateTime = DateUtil.setTimeZone(sentDateTime);
    }

    
    public String getMaskedMessage() {
        return message.replaceAll("[0-9]{10}", "XXXXXXXXXX");
    }
}
