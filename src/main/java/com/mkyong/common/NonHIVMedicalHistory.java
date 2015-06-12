package com.mkyong.common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.motechproject.tama.common.domain.BaseEntity;

@Entity
@Table
public class NonHIVMedicalHistory extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToMany(cascade = {CascadeType.ALL})
    private List<AllergyHistory> allergiesHistory = new LinkedList<AllergyHistory>();

	@ElementCollection
	private List<String> rashes = new ArrayList<String>();

	@OneToMany(cascade = {CascadeType.ALL})
    private List<SystemCategory> systemCategories = new LinkedList<SystemCategory>();

	@OneToMany(cascade = {CascadeType.ALL})
    private List<MedicalHistoryQuestion> questions = new LinkedList<MedicalHistoryQuestion>();

    public List<MedicalHistoryQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<MedicalHistoryQuestion> questions) {
        this.questions = questions;
    }

    public List<AllergyHistory> getAllergiesHistory() {
        return allergiesHistory;
    }

    public void setAllergiesHistory(List<AllergyHistory> allergiesHistory) {
        this.allergiesHistory = allergiesHistory;
    }

    public List<String> getRashes() {
        return rashes;
    }

    public void setRashes(List<String> rashes) {
        this.rashes = rashes;
    }

    public void setSystemCategories(List<SystemCategory> systemCategories) {
        this.systemCategories = systemCategories;
    }

    public List<AllergyHistory> getSpecifiedAllergies() {
        ArrayList<AllergyHistory> specifiedAllergies = new ArrayList<AllergyHistory>();
        for (AllergyHistory allergyHistory : allergiesHistory) {
            if (allergyHistory.isSpecified())
                specifiedAllergies.add(allergyHistory);
        }
        return specifiedAllergies;
    }

    public NonHIVMedicalHistory addSystemCategory(SystemCategory... systemCategory) {
        systemCategories.addAll(Arrays.asList(systemCategory));
        return this;
    }

    public List<SystemCategory> getSystemCategories() {
        return systemCategories;
    }

    
    
}
