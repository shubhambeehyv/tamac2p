package com.mkyong.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * 
 * @author henrik lundgren
 *
 */
@MappedSuperclass
public class CouchDbDocument implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="_id")
	private String id;
	@Column(name="_rev")
	private String revision;
	
	
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String s) {
		
		if (id != null && id.equals(s)) {
		    return;
		}
	    if (id != null) {
			throw new IllegalStateException("cannot set id, id already set");
		}
		id = s;
	}
	
	
	
	public String getRevision() {
		return revision;
	}
	
	//@JsonProperty("_rev")
	public void setRevision(String s) {
		// no empty strings thanks 
		if (s != null && s.length() == 0) {
			return;
		}
		this.revision = s;
	}
	//@JsonIgnore
	public boolean isNew() {
		return revision == null;
	}
	
	
	
	
	
	/**
	 * 
	 * @return a list of conflicting revisions. Note: Will only be populated if this document has been loaded through the CouchDbConnector.getWithConflicts method.
	 */
	

	/**
	 * 
	 * @return true if this document has a conflict. Note: Will only give a correct value if this document has been loaded through the CouchDbConnector.getWithConflicts method.
	 */
	

	
	
	
}