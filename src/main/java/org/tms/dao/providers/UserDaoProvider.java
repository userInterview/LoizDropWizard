package org.tms.dao.providers;

import javax.inject.Inject;
import javax.inject.Provider;

import org.skife.jdbi.v2.DBI;

import org.tms.configuration.BasicConfiguration;
import org.tms.repositories.UserDAO ;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;


public class UserDaoProvider implements Provider<UserDAO> {
	
	private static DBI static_jdbi ;
	
	private UserDAO userDAO ; 
	
	@Inject	
	BasicConfiguration basicConfiguration ;
	
	@Inject
	Environment environment ;
	
    @Override
    public UserDAO get() {    	    	 
    	if (static_jdbi == null ) {
          final DBIFactory factory = new DBIFactory();            
          static_jdbi = factory.build(environment, basicConfiguration.getDataSourceFactory(), "postgresql");           
          }
    	userDAO = static_jdbi.onDemand(UserDAO.class);
          return userDAO ;
    }
}