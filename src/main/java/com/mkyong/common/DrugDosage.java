package com.mkyong.common;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table
public class DrugDosage {
	
	@Id
	@GeneratedValue
	private Integer id;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
    private String drugId;

    private String drugName;

    @NotNull
    private String brandId;

    @NotNull
    private String dosageTypeId;

    private Integer offsetDays = 0;

    public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getDosageTypeId() {
		return dosageTypeId;
	}

	public void setDosageTypeId(String dosageTypeId) {
		this.dosageTypeId = dosageTypeId;
	}

	public Integer getOffsetDays() {
		return offsetDays;
	}

	public void setOffsetDays(Integer offsetDays) {
		this.offsetDays = offsetDays;
	}

	public String getMorningTime() {
		return morningTime;
	}

	public void setMorningTime(String morningTime) {
		this.morningTime = morningTime;
	}

	public String getEveningTime() {
		return eveningTime;
	}

	public void setEveningTime(String eveningTime) {
		this.eveningTime = eveningTime;
	}

	public Date getStartDateAsDate() {
		return startDateAsDate;
	}

	public void setStartDateAsDate(Date startDateAsDate) {
		this.startDateAsDate = startDateAsDate;
	}

	public Date getEndDateAsDate() {
		return endDateAsDate;
	}

	public void setEndDateAsDate(Date endDateAsDate) {
		this.endDateAsDate = endDateAsDate;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getMealAdviceId() {
		return mealAdviceId;
	}

	public void setMealAdviceId(String mealAdviceId) {
		this.mealAdviceId = mealAdviceId;
	}

	@NotNull
    private String morningTime;

    @NotNull
    private String eveningTime;

    @NotNull
    private Date startDateAsDate;

  
    private Date endDateAsDate;

    private String advice;

    @NotNull
    private String mealAdviceId;

  
    

    
    
  

    
}
