package com.dropwizard;

import org.skife.jdbi.v2.DBI;

import com.dropwizard.introduction.configuration.BasicConfiguration;
import com.dropwizard.introduction.repositories.BrandDAO;
//import com.dropwizard.introduction.dao.guicemodules.LoizInjectGuiceModule;
import com.dropwizard.introduction.resource.BrandResource;
//import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;



public class MainApplication extends Application<BasicConfiguration> {

	
//	private GuiceBundle guiceBundle;
//    private Injector injector;
	
    public static void main(final String[] args) throws Exception {
    	System.out.println("dans le main 6");
    	new MainApplication().run(args);
    }
    
    @Override
    public String getName() {
        return "***************************** TM - PRESENTATION DROPWIZARD ********************";
    }
    
    @Override
    public void initialize(final Bootstrap<BasicConfiguration> bootstrap) {    	
    	
//
//    	
//    	bootstrap.addBundle( GuiceBundle.builder().enableAutoConfig(getClass().getPackage().getName()).modules(
//    			new LoizInjectGuiceModule()).searchCommands().build()) ;
    	
    	bootstrap.addBundle(GuiceBundle.builder()
    			//.modules(new LoizInjectGuiceModule())
    			.enableAutoConfig(this.getClass().getPackage().getName())    			
    			.build());
    }
    
 /* @Override
    public void run(final BasicConfiguration basicConfiguration, final Environment environment) {
	  
//	  	Guice.createInjector(new LoizInjectGuiceModule());
//	    Injector injector = Guice.createInjector(new LoizInjectGuiceModule());
//	    LoizInjectService guiceLoizInjectService = injector.getInstance(LoizInjectService.class);
//	    userService.getAttrLoizInject()
	    
//	  	final DBIFactory factory = new DBIFactory();        
//      final DBI jdbi = factory.build(environment, basicConfiguration.getDataSourceFactory(), "postgresql") ; 
//      final BrandDAO brandDAO = jdbi.onDemand(BrandDAO.class);
//      final BrandResource brandResource = new BrandResource(brandDAO);
//      environment.jersey().register(brandResource);
      	environment.jersey().register(BrandResource.class);
        
    	
    	
    }*/
    @Override
    public void run(final BasicConfiguration basicConfiguration, final Environment environment) { 
//        final DBIFactory factory = new DBIFactory();        
//        final DBI jdbi = factory.build(environment, basicConfiguration.getDataSourceFactory(), "postgresql");
//
//        final BrandDAO brandDAO = jdbi.onDemand(BrandDAO.class);
//        final BrandResource brandResource = new BrandResource(brandDAO);
//
//        environment.jersey().register(brandResource);
    	 environment.jersey().register(BrandResource.class);
    	
    	
    }  
    
}
