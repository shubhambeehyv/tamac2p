package com.mkyong.common;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MotechBaseDataObject extends CouchDbDocument {

    protected String type;

    protected MotechBaseDataObject() {
        this.type = this.getClass().getSimpleName();
    }

    protected MotechBaseDataObject(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private static final long serialVersionUID = 1L;
}