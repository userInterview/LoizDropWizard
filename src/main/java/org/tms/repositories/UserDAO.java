package org.tms.repositories;
import org.tms.dao.mappers.UserMapper;
import org.tms.domain.User;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public abstract class UserDAO {

    @SqlQuery("SELECT id, name FROM fullnames")
    @Mapper(UserMapper.class)
	public abstract List<User> findAll();      
    
    @SqlUpdate("INSERT INTO fullnames (name) VALUES (:columnName)")    
    public abstract void createFullNames(@Bind("columnName") String strFulname);    

    @SqlUpdate("TRUNCATE TABLE fullnames RESTART IDENTITY")
    public abstract void clearTableFullNames();    
    
    @Transaction
    public List<User> clearAndCreateEntries(int nbEntries) {
    	
		clearTableFullNames() ;
		
		for (int i = 0 ; i <= nbEntries ; i++) {
			createFullNames("nom" + i + " prenom " + i);
		}
		
		return findAll();		
    }
    
}
