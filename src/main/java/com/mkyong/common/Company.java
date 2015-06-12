package com.mkyong.common;

import javax.validation.constraints.NotNull;

import org.motechproject.tama.common.domain.CouchEntity;

public class Company extends CouchEntity {

    @NotNull
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}