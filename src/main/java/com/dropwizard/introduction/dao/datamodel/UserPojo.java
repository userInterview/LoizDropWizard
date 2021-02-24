package com.dropwizard.introduction.dao.datamodel;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrandPojo {
	
    @NotNull
    @JsonProperty
    private int Id;
    
    @NotNull
    @JsonProperty
    private String name ;


    public BrandPojo() {
		super();
		// TODO Auto-generated constructor stub
	}    
    
    
	public BrandPojo(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	@Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
