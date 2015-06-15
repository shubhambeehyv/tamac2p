package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class OpportunisticInfection extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}