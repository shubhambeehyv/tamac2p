package com.mkyong.common;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.motechproject.tama.common.domain.BaseEntity;
@Entity
@Table
public class SystemCategory extends BaseEntity {

	@Id
	@GeneratedValue		
    private Integer id;
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String name;
	@ManyToOne
	private NonHIVMedicalHistory nonHIVMedicalHistory; 

    public NonHIVMedicalHistory getNonHIVMedicalHistory() {
		return nonHIVMedicalHistory;
	}

	public void setNonHIVMedicalHistory(NonHIVMedicalHistory nonHIVMedicalHistory) {
		this.nonHIVMedicalHistory = nonHIVMedicalHistory;
	}

	@OneToOne(cascade = {CascadeType.ALL})
    private Ailments ailments = new Ailments();

    public SystemCategory() {
    }

    public SystemCategory(String name, Ailments ailments) {
        this.name = name;
        this.ailments = ailments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ailments getAilments() {
        return ailments;  
    }

    public void setAilments(Ailments ailments) {
        this.ailments = ailments;
    }

    
    public boolean isCategoryEmpty() {
        return ailments.isEmpty();
    }

    public static SystemCategory newSystemCategory(String name, Ailments ailments) {
        final SystemCategory systemCategory = new SystemCategory();
        systemCategory.setAilments(ailments);
        systemCategory.setName(name);
        return systemCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemCategory that = (SystemCategory) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
