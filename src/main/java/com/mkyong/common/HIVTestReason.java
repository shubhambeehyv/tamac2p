package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class HIVTestReason extends CouchEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
    private String name;

    public HIVTestReason() {
    }

    public HIVTestReason(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static HIVTestReason newHIVTestReason(String name) {
        HIVTestReason mode = new HIVTestReason();
        mode.setName(name);
        return mode;
    }
}
