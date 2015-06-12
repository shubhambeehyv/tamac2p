package com.mkyong.common.RegimenH;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.motechproject.tama.common.util.UUIDUtil;

@Entity
@Table
public class DrugComposition {

	@Id
    private String id;

	@ElementCollection
    private Set<String> drugIds = new HashSet<String>();

  
    private String displayName;

    public DrugComposition() {
        id = UUIDUtil.newUUID();
    }

  

    public Set<String> getDrugIds() {
        return this.drugIds;
    }

    public void setDrugIds(Set<String> drugIds) {
        this.drugIds = drugIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

   
}
