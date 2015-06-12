package com.mkyong.common;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.motechproject.tama.common.domain.BaseEntity;

@Entity
@Table
public class AllergyHistory extends BaseEntity {
	@Getter
	@Setter
	@Id
	@GeneratedValue
	private Integer id;
	

	
    private String drugAllergy;
    private boolean specified;
    private String description;
    @ManyToOne(cascade = {CascadeType.ALL})
    private NonHIVMedicalHistory nonHIVMedicalHistory;

    public NonHIVMedicalHistory getNonHIVMedicalHistory() {
		return nonHIVMedicalHistory;
	}

	public void setNonHIVMedicalHistory(NonHIVMedicalHistory nonHIVMedicalHistory) {
		this.nonHIVMedicalHistory = nonHIVMedicalHistory;
	}

	public String getDrugAllergy() {
        return drugAllergy;
    }

    public void setDrugAllergy(String drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSpecified() {
        return specified;
    }

    public void setSpecified(boolean specified) {
        this.specified = specified;
    }
}
