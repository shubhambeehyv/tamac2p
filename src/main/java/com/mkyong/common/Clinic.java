package com.mkyong.common;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mkyong.extras.CouchEntity;
@Entity
@Table
public class Clinic extends CouchEntity {

	
	@NotNull
	private String name;

	@NotNull
	private String greetingName;

	@NotNull
	private String address;

	@NotNull
	private String phone;

	@Size(min = 1, max = 3, message = "Please enter the contact details for at least one clinician")
	@OneToMany(cascade = {CascadeType.ALL})
	@Valid
	private List<ClinicianContact> clinicianContacts = new LinkedList<ClinicianContact>();
	
	@ManyToOne
	private MonitoringAgent monitoringAgent;

	@ManyToOne
	private City city;

	public City getCity() {
		return city;
	}

	private String cityId;

	protected Clinic() {
	}

	public Clinic(String _id) {
		this.setId(_id);
	}

	@Override
	public String toString() {
		return this.name;
	}

	public static Clinic newClinic() {
		return new Clinic();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreetingName() {
		return greetingName;
	}

	public void setGreetingName(String greetingName) {
		this.greetingName = greetingName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ClinicianContact> getClinicianContacts() {
		return clinicianContacts;
	}

	public void setClinicianContacts(List<ClinicianContact> clinicianContacts) {
		this.clinicianContacts = clinicianContacts;
	}

	public void setCity(City city) {
		this.city = city;
		this.cityId = city.getId();
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public MonitoringAgent getMonitoringAgent() {
		return monitoringAgent;
	}

	public void setMonitoringAgent(MonitoringAgent monitoringAgent) {
		this.monitoringAgent = monitoringAgent;
	}

	
}