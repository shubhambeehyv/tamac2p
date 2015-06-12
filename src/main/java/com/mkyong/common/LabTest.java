package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mkyong.extras.CouchEntity;


@Entity
@Table
public class LabTest extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String name;

    String normalRange;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

 
}
