package com.dropwizard.application;

import com.dropwizard.introduction.configuration.BasicConfiguration;
import com.dropwizard.introduction.dao.guicemodules.LoizInjectGuiceModule;
import com.dropwizard.introduction.repositories.BrandDAO;
import com.dropwizard.introduction.resource.BrandResource;
import com.google.inject.Injector;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


import org.skife.jdbi.v2.DBI;

public class MainApplication extends Application<BasicConfiguration> {

	Injector injector;
	private GuiceBundle<BasicConfiguration> guiceBundle;
	
    public static void main(final String[] args) throws Exception {
    	System.out.println("dans le main");
    	new MainApplication().run(args);
    }
    
    @Override
    public String getName() {
        return "TM - PRESENTATION DROPWIZARD";
    }
    
    @Override
    public void initialize(final Bootstrap<BasicConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.<BasicConfiguration>newBuilder()
                .addModule(new LoizInjectGuiceModule())
                .setConfigClass(BasicConfiguration.class)
                .build();
        bootstrap.addBundle(guiceBundle);
    }    

    
  @Override
    public void run(final BasicConfiguration basicConfiguration, final Environment environment) { 
        final DBIFactory factory = new DBIFactory();        
        final DBI jdbi = factory.build(environment, basicConfiguration.getDataSourceFactory(), "postgresql");

        final BrandDAO brandDAO = jdbi.onDemand(BrandDAO.class);
        final BrandResource personResource = new BrandResource(brandDAO);
        environment.jersey().register(personResource);
    	
    	
    }
    
    
}
