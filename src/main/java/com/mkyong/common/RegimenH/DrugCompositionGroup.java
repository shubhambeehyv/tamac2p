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
public class DrugCompositionGroup extends CouchEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
   
    private String id ;

    @NotNull
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<DrugComposition> drugCompositions = new HashSet<DrugComposition>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DrugComposition> getDrugCompositions() {
		return drugCompositions;
	}

	public void setDrugCompositions(Set<DrugComposition> drugCompositions) {
		this.drugCompositions = drugCompositions;
	}
    
}