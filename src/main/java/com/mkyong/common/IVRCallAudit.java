package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class IVRCallAudit extends CouchEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cid;
    private String sid;
    private String patientId;
    private String state;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime dateTime;

    public IVRCallAudit() {
    }

  

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public enum State {
        PASSCODE_ENTRY_FAILED {
            @Override
            public String toString() {
                return "passcode entry failed";
            }
        }, USER_NOT_FOUND {
            @Override
            public String toString() {
                return "user not found";
            }
        }, USER_AUTHORISED {
            @Override
            public String toString() {
                return "user authorised";
            }
        };
    }
}
