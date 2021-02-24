package com.dropwizard.introduction.dao.providers;

import javax.inject.Inject;
import javax.inject.Provider;

import org.skife.jdbi.v2.DBI;

import com.dropwizard.introduction.configuration.BasicConfiguration;
import com.dropwizard.introduction.repositories.BrandDAO ;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;


public class BrandDaoProvider implements Provider<BrandDAO> {
	
	private static DBI static_jdbi ;
	
	private BrandDAO brandDAO ; 
	
	@Inject	
	BasicConfiguration basicConfiguration ;
	
	@Inject
	Environment environment ;
	
    @Override
    public BrandDAO get() {    	    	 
    	if (static_jdbi == null ) {
          final DBIFactory factory = new DBIFactory();            
          static_jdbi = factory.build(environment, basicConfiguration.getDataSourceFactory(), "postgresql");           
          }
    	brandDAO = static_jdbi.onDemand(BrandDAO.class);
          return brandDAO ;
    }
}