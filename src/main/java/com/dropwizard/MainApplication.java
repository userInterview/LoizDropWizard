package com.dropwizard;

import com.dropwizard.introduction.configuration.BasicConfiguration;
import com.dropwizard.introduction.dao.guicemodules.LoizInjectGuiceModule;
import com.dropwizard.introduction.resource.BrandResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class MainApplication extends Application<BasicConfiguration> {

	
    public static void main(final String[] args) throws Exception {
    	System.out.println("dans le main 6");
    	new MainApplication().run(args);
    }
    
    @Override
    public String getName() {
        return "**************** TM - PRESENTATION DROPWIZARD ********************";
    }
    
    @Override
    public void initialize(final Bootstrap<BasicConfiguration> bootstrap) {    	
    	bootstrap.addBundle(GuiceBundle.builder()
    			.modules(new LoizInjectGuiceModule())
    			//.enableAutoConfig(this.getClass().getPackage().getName())
    			.enableAutoConfig("com.dropwizard")
    			.build());
    }    

    @Override
    public void run(final BasicConfiguration basicConfiguration, final Environment environment) { 

    	 environment.jersey().register(BrandResource.class);
    	
    	
    }  
    
}
