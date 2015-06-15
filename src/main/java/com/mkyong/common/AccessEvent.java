package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.motechproject.util.DateUtil;


@Entity
@Table
public class AccessEvent extends TAMAEvent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum AccessEventType {Login, Logout};

     String userName;
     String sourceAddress;
     String sessionId;
     String eventType;
     String loginStatus;

    public AccessEvent() {}

    public AccessEvent(String userName, String sourceAddress, String sessionId, String eventType, String status) {
        super(DateUtil.now());
        this.userName = userName;
        this.sourceAddress = sourceAddress;
        this.sessionId = sessionId;
        this.eventType = eventType;
        this.loginStatus = status;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
}