package com.mkyong.common;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

    @Table
	@Entity
	public  class ClinicianContact implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@ManyToOne(cascade = {CascadeType.ALL})
		private Clinic clinic; 

		// @NotNull(message = "Clinician name is mandatory")
		private String name;

		@Id
		private String id;

		// @NotNull(message = "Phone number is mandatory")

		private String phoneNumber;

		public ClinicianContact(Clinic clinic) {
			setClinic(clinic);

			
		}

		public ClinicianContact(String name, String phoneNumber) {
			this.name = name;
			this.phoneNumber = phoneNumber;
		}

		public String get_id() {
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

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Clinic getClinic() {
			return clinic;
		}

		public void setClinic(Clinic clinic) {
			this.clinic = clinic;
		}
	}