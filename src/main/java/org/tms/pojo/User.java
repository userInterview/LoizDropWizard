package org.tms.pojo;

public class User {	

	private Long id;
    private String name;
	
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}


    public User(Long id, String name) {
    	super();
        this.id = id;
        this.name = name;
    } 

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}
    
    
}