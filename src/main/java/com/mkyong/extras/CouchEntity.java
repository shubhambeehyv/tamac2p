package com.mkyong.extras;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.LocalDate;

import com.mkyong.common.MotechBaseDataObject;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class CouchEntity extends MotechBaseDataObject {

    private static final long serialVersionUID = 4517930750095396426L;
    
    @Transient
    private String documentType;

    public CouchEntity() {
        this.documentType = this.getClass().getSimpleName();
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    
    public Integer getVersion() {
        if (getRevision() == null) return -1;
        return Integer.parseInt(getRevision().split("-")[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CouchEntity that = (CouchEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return getId() != null ? ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE) : super.toString();
    }

    protected Date toDate(LocalDate date) {
        if (date == null) return null;
        return date.toDate();
    }
}
