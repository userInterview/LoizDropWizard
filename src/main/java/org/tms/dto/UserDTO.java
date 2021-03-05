package org.tms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
	
    @NotNull
    @JsonProperty    
    private Long id;
    
    @NotBlank
    @JsonProperty
    private String name ;


    public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}    
    
    
	public UserDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public UserDTO(String name) {
		super();
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
