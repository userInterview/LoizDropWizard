package org.tms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tms.configuration.BasicConfiguration;
import org.tms.dao.guicemodules.LoizInjectGuiceModule;
import org.tms.resource.UserResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import com.codahale.metrics.CachedGauge;

public class MainApplication extends Application<BasicConfiguration> {


	private static Logger logger = LoggerFactory.getLogger(MainApplication.class);
	
	
    public static void main(final String[] args) throws Exception {
    	logger.info("Starting main method");
    	new MainApplication().run(args);
    }
    
    @Override
    public void initialize(final Bootstrap<BasicConfiguration> bootstrap) {  
    	logger.info("Starting initialize method");
    	bootstrap.addBundle(GuiceBundle.builder()
    			.modules(new LoizInjectGuiceModule())
    			.enableAutoConfig(this.getClass().getPackage().getName())    			
    			.build());
    }    

    @Override
    public void run(final BasicConfiguration basicConfiguration, final Environment environment) {
    	 logger.info("Starting run method");
    	 environment.jersey().register(UserResource.class);
    }  
    
}
