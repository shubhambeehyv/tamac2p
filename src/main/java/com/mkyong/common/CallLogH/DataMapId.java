package com.mkyong.common.CallLogH;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


	@Embeddable
	public class DataMapId implements Serializable{
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String key;
		 @ManyToOne(cascade = {CascadeType.ALL})
	     private CallEvent callEvent;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public CallEvent getCallEvent() {
			return callEvent;
		}
		public void setCallEvent(CallEvent callEvent) {
			this.callEvent = callEvent;
		}
	}

