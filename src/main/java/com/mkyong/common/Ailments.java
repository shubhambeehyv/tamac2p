package com.mkyong.common;



import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Ailments {
	@Id
	@GeneratedValue
	@Column(name="AilmentId")
	private Integer id;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@OneToMany(cascade = {CascadeType.ALL})
    private List<Ailment> ailments = new LinkedList<Ailment>();

	@OneToMany(cascade = {CascadeType.ALL})
    private List<OtherAilment> otherAilments = new LinkedList<OtherAilment>();

    public List<OtherAilment> getOtherAilments() {
        return otherAilments;
    }

    public Ailments setOtherAilments(List<OtherAilment> otherAilments) {
        this.otherAilments = otherAilments;
        return this;
    }

    public List<Ailment> getAilments() {
        return ailments;
    }

    public Ailments setAilments(List<Ailment> ailments) {
        this.ailments = ailments;
        return this;
    }

    
    public boolean hasOtherAilments() {
        return !otherAilments.isEmpty();
    }

   
    public boolean isNotEmpty() {
        return !ailments.isEmpty();
    }

    
    public boolean isEmpty() {
        return ailments.isEmpty();
    }

    
   
}
