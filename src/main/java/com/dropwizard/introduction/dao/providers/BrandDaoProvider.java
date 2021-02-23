package com.dropwizard.introduction.dao.providers;

import javax.inject.Inject;
import javax.inject.Provider;

import org.skife.jdbi.v2.DBI;

import com.dropwizard.introduction.configuration.BasicConfiguration;
import com.dropwizard.introduction.repositories.BrandDAO ;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;


public class BrandDaoProvider implements Provider<BrandDAO> {
	
	@Inject	
	BasicConfiguration basicConfiguration ;
	
	@Inject
	Environment environment ;
	
    @Override
    public BrandDAO get() {    	    	 
          final DBIFactory factory = new DBIFactory();        
          final DBI jdbi = factory.build(environment, basicConfiguration.getDataSourceFactory(), "postgresql");  
          final BrandDAO brandDAO = jdbi.onDemand(BrandDAO.class);
    	
          return brandDAO ;
    }
}