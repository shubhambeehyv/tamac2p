package com.mkyong.common.PillRegimenH;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mkyong.common.MotechBaseDataObject;


@Entity
@Table
public class PillRegimen extends MotechBaseDataObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6404167167442696445L;
	private String externalId;
	@Embedded
    private DailyScheduleDetails scheduleDetails;
	@OneToMany(cascade = CascadeType.ALL)
    private Set<Dosage> dosages;

    public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public DailyScheduleDetails getScheduleDetails() {
		return scheduleDetails;
	}

	public void setScheduleDetails(DailyScheduleDetails scheduleDetails) {
		this.scheduleDetails = scheduleDetails;
	}

	public Set<Dosage> getDosages() {
		return dosages;
	}

	public void setDosages(Set<Dosage> dosages) {
		this.dosages = dosages;
	}

	public PillRegimen() {
    }
}