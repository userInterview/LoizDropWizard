package org.tms.dao.datamodel;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPojo {
	
    @NotNull
    @JsonProperty    
    private int id;
    
    @NotNull
    @JsonProperty
    private String name ;


    public UserPojo() {
		super();
		// TODO Auto-generated constructor stub
	}    
    
    
	public UserPojo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public UserPojo(String name) {
		super();
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
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
                "Id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
