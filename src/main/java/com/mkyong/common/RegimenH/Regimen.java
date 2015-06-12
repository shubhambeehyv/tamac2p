package com.mkyong.common.RegimenH;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mkyong.extras.CouchEntity;


@Entity
@Table
public class Regimen extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    private String name;

    @NotNull
    private String displayName;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<DrugCompositionGroup> drugCompositionGroups = new HashSet<DrugCompositionGroup>();

    public Regimen() {
    }

    public Regimen(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Set<DrugCompositionGroup> getDrugCompositionGroups() {
		return drugCompositionGroups;
	}

	public void setDrugCompositionGroups(
			Set<DrugCompositionGroup> drugCompositionGroups) {
		this.drugCompositionGroups = drugCompositionGroups;
	}
}