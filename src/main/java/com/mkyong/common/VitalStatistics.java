package com.mkyong.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class VitalStatistics extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int INVALID_HEIGHT = 0;
    private static final int INVALID_WEIGHT = 0;

    private Double weightInKg;

    private Double heightInCm;

    private Integer systolicBp;

    private Integer diastolicBp;

    private Double temperatureInFahrenheit;

    private Integer pulse;

    @NotNull
    private String patientId;

    public Double getWeightInKg() {
		return weightInKg;
	}

	public void setWeightInKg(Double weightInKg) {
		this.weightInKg = weightInKg;
	}

	public Double getHeightInCm() {
		return heightInCm;
	}

	public void setHeightInCm(Double heightInCm) {
		this.heightInCm = heightInCm;
	}

	public Integer getSystolicBp() {
		return systolicBp;
	}

	public void setSystolicBp(Integer systolicBp) {
		this.systolicBp = systolicBp;
	}

	public Integer getDiastolicBp() {
		return diastolicBp;
	}

	public void setDiastolicBp(Integer diastolicBp) {
		this.diastolicBp = diastolicBp;
	}

	public Double getTemperatureInFahrenheit() {
		return temperatureInFahrenheit;
	}

	public void setTemperatureInFahrenheit(Double temperatureInFahrenheit) {
		this.temperatureInFahrenheit = temperatureInFahrenheit;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public Date getCaptureDate() {
		return captureDate;
	}

	public void setCaptureDate(Date captureDate) {
		this.captureDate = captureDate;
	}

	public static int getInvalidWeight() {
		return INVALID_WEIGHT;
	}

	private Date captureDate;

    public VitalStatistics() {
    }
}