package org.tms.dao.guicemodules;


import org.tms.services.Userservice;
import org.tms.services.Userserviceimpl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;


public class LoizInjectGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
	   	bind(LoizInjectInterface.class)
	   			.annotatedWith(Names.named("loiznamed"))
	   			.toInstance(new LoizInject("Abstract Module - définie dans méthode configure() par binding nommé "));	   	
	   	
	   	bind(Userservice.class)
	   			.to(Userserviceimpl.class) ;
	}

	@Provides
	public LoizInjectInterface getLoizInject() {
		return new LoizInject("Abstract Module - val par @Provided");				
	}

}