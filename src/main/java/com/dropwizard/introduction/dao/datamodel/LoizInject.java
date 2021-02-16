package com.dropwizard.introduction.dao.datamodel;

//import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class LoizInject {

    
    @NotNull
    @JsonProperty
    private String name ;


    public LoizInject() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public LoizInject( String name) {
		super();
		this.name = name;
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
                ", name='" + name + '\'' +
                '}';
    }
}
