package org.tms.dao.mappers;



import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.tms.dao.datamodel.UserPojo;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements ResultSetMapper<UserPojo> {
    
    public UserPojo map(int index, ResultSet rs, org.skife.jdbi.v2.StatementContext ctx) throws SQLException 
    {  	    	 	    	
        return new UserPojo(rs.getInt("id"), rs.getString("name"));
    }
}
