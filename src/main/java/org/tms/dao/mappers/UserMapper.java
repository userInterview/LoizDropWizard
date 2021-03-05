package org.tms.dao.mappers;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.tms.pojo.User;

public class UserMapper implements ResultSetMapper<User> {
	
    @Override
    public User map(int index, ResultSet rs, org.skife.jdbi.v2.StatementContext ctx) throws SQLException 
    {  	    	 	    	
        return new User(rs.getLong("id"), rs.getString("name"));
    }
}
