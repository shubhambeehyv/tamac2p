package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mkyong.extras.BaseEntity;

@Table
@Entity
public class OtherAilment  extends BaseEntity{
	 private String description;
		@Id
		@GeneratedValue
		private Integer id;
		
		@ManyToOne
		private Ailments ailments;
		
		
	    private String definition;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	
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


   
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    }

