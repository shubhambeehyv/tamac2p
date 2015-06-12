package com.mkyong.common.PillRegimenH;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Dosage {
	@Id
    private String id;
    private String dosageTime;
    
    private Date responseLastCapturedDate;
    // from medicine set
    private String medicines;
	public String getId() {
		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDosageTime() {
		return dosageTime;
	}
	public void setDosageTime(String dosageTime) {
		this.dosageTime = dosageTime;
	}
	public Date getResponseLastCapturedDate() {
		return responseLastCapturedDate;
	}
	public void setResponseLastCapturedDate(Date responseLastCapturedDate) {
		this.responseLastCapturedDate = responseLastCapturedDate;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

    
}