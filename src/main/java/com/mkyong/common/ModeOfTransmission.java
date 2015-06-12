package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class ModeOfTransmission extends CouchEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

    public ModeOfTransmission() {
    }


    

    public static ModeOfTransmission newModeOfTransmission(String type) {
        ModeOfTransmission mode = new ModeOfTransmission();
        mode.setType(type);
        return mode;
    }
}
