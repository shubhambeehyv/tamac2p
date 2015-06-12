package com.mkyong.common;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.motechproject.tama.common.domain.BaseEntity;

@Entity
@Table
public class Ailment extends BaseEntity {
	
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Ailments ailments;
	
	
    private String definition;

	
    private String state = AilmentState.NONE.toString();

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ailment ailment = (Ailment) o;

        return definition == ailment.definition;

    }

    @Override
    public int hashCode() {
        return definition != null ? definition.hashCode() : 0;
    }

   
    public boolean everHadTheAilment() {
        return !state.equals(AilmentState.NONE);
    }

	public Ailments getAilments() {
		return ailments;
	}

	public void setAilments(Ailments ailments) {
		this.ailments = ailments;
	}
}
