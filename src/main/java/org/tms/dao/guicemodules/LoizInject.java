package org.tms.dao.guicemodules;


import javax.inject.Singleton;
//import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Singleton
public class LoizInject implements LoizInjectInterface {

	
	@NotNull
    @JsonProperty
    private String name ;

 
    public LoizInject() {
		super();
		// TODO Auto-generated constructor stub
	}    
   
	public LoizInject( String name) {		
		this.name = name;
	}
	
    @Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

//	@Override
//    public String toString() {
//        return "Account{" +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
