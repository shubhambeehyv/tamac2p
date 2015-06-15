package com.mkyong.common;

import javax.validation.constraints.NotNull;

import org.motechproject.tama.common.domain.CouchEntity;

public class UniquePatientField extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getPrimaryDocId() {
		return primaryDocId;
	}
	public void setPrimaryDocId(String primaryDocId) {
		this.primaryDocId = primaryDocId;
	}
	@NotNull
    String primaryDocId;
}