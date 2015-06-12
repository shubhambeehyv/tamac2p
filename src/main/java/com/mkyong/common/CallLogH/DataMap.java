package com.mkyong.common.CallLogH;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
@Entity
@Table

public class DataMap {
     

	@EmbeddedId
	private DataMapId id;
     @Type(type="org.hibernate.type.TextType")
     private String value;
    
	public String getValue() { 
		return value;
	}
	public DataMapId getId() {
		return id;
	}
	public void setId(DataMapId id) {
		this.id = id;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
     
}

