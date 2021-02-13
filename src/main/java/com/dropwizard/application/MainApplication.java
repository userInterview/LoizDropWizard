package com.dropwizard.application;


import com.dropwizard.introduction.configuration.BasicConfiguration;
import com.dropwizard.introduction.repositories.BrandDAO;
import com.dropwizard.introduction.resource.BrandResource;

import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.guicey.gsp.ServerPagesBundle;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.server.session.SessionHandler;
import org.skife.jdbi.v2.DBI;

public class MainApplication extends Application<BasicConfiguration> {

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
