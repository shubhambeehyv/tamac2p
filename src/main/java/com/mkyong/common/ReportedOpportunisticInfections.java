package com.mkyong.common;




import com.mkyong.extras.CouchEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class ReportedOpportunisticInfections extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    @ElementCollection
    private List<String> opportunisticInfectionIds = new ArrayList<String>();

    private String otherOpportunisticInfectionDetails;

    @NotNull
    private String patientId;

    private Date captureDate;

    public List<String> getOpportunisticInfectionIds() {
        return opportunisticInfectionIds;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    public Date getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    public void setOtherOpportunisticInfectionDetails(String otherOpportunisticInfectionDetails) {
        this.otherOpportunisticInfectionDetails = otherOpportunisticInfectionDetails;
    }

    public String getOtherOpportunisticInfectionDetails() {
        return otherOpportunisticInfectionDetails;
    }

    public void addOpportunisticInfection(OpportunisticInfection opportunisticInfection) {
        opportunisticInfectionIds.add(opportunisticInfection.getId());
    }

}

