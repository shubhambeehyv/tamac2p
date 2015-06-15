package com.mkyong.common;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;


@MappedSuperclass
public class TAMAEvent extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
	DateTime dateTime;
    String baseClass = "TAMAEvent";

    public TAMAEvent() {
        setType(TAMAEvent.class.getSimpleName()); 
    }

    public TAMAEvent(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}