package com.mkyong.common;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.mkyong.extras.CouchEntity;
@Entity
@Table
public class Gender extends CouchEntity  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;






	public Gender(String id) {
	        this.setId(id);
	    }

    public Gender() {
    }

   

  
    

    public static Gender newGender(String type) {
        Gender gender = new Gender();
        gender.setType(type);
        return gender;
    }
}
