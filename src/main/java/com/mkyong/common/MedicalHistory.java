package com.mkyong.common;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.motechproject.tama.common.domain.BaseEntity;

@Entity
@Table
public class MedicalHistory extends BaseEntity {
	
	@GeneratedValue
	@Id
	private Integer id;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(cascade = {CascadeType.ALL})
    private HIVMedicalHistory hivMedicalHistory;
	@OneToOne(cascade = {CascadeType.ALL})
    private NonHIVMedicalHistory nonHivMedicalHistory;

    public HIVMedicalHistory getHivMedicalHistory() {
        return hivMedicalHistory;
    }

    public void setHivMedicalHistory(HIVMedicalHistory hivMedicalHistory) {
        this.hivMedicalHistory = hivMedicalHistory;
    }

    public NonHIVMedicalHistory getNonHivMedicalHistory() {
        return nonHivMedicalHistory;
    }

    public void setNonHivMedicalHistory(NonHIVMedicalHistory nonHivMedicalHistory) {
        this.nonHivMedicalHistory = nonHivMedicalHistory;
    }
}
