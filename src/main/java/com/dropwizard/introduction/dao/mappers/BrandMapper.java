package com.dropwizard.introduction.dao.mappers;



import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.dropwizard.introduction.dao.datamodel.BrandPojo;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BrandMapper implements ResultSetMapper<BrandPojo> {
    
    public BrandPojo map(int index, ResultSet rs, org.skife.jdbi.v2.StatementContext ctx) throws SQLException 
    {  	    	 	    	
        return new BrandPojo(rs.getInt("id"), rs.getString("name"));
    }
}
