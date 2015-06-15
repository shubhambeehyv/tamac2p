package com.mkyong.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mkyong.extras.CouchEntity;



@Entity
@Table
public class TreatmentAdvice extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getRegimenId() {
		return regimenId;
	}

	public void setRegimenId(String regimenId) {
		this.regimenId = regimenId;
	}

	public String getDrugCompositionId() {
		return drugCompositionId;
	}

	public void setDrugCompositionId(String drugCompositionId) {
		this.drugCompositionId = drugCompositionId;
	}

	public String getDrugCompositionGroupId() {
		return drugCompositionGroupId;
	}

	public void setDrugCompositionGroupId(String drugCompositionGroupId) {
		this.drugCompositionGroupId = drugCompositionGroupId;
	}

	public String getReasonForDiscontinuing() {
		return reasonForDiscontinuing;
	}

	public void setReasonForDiscontinuing(String reasonForDiscontinuing) {
		this.reasonForDiscontinuing = reasonForDiscontinuing;
	}

	public List<DrugDosage> getDrugDosages() {
		return drugDosages;
	}

	public void setDrugDosages(List<DrugDosage> drugDosages) {
		this.drugDosages = drugDosages;
	}

	public static int getDaysInFiveWeeks() {
		return DAYS_IN_FIVE_WEEKS;
	}

	public static final int DAYS_IN_FIVE_WEEKS = 35;

    @NotNull
    private String patientId;

    @NotNull
    private String regimenId;

    @NotNull
    private String drugCompositionId;

    @NotNull
    private String drugCompositionGroupId;

    @NotNull
    private String reasonForDiscontinuing;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<DrugDosage> drugDosages = new ArrayList<DrugDosage>();
}
