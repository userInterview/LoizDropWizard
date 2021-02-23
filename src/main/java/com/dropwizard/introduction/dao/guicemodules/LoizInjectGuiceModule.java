package com.dropwizard.introduction.dao.guicemodules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;



public class LoizInjectGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
	   	bind(LoizInjectInterface.class).annotatedWith(Names.named("loizBindedNamed")).toInstance(new LoizInject("Abstract Module - val définie dans méthode configure() par binding nommé "));  	
	}

	@Provides
	public LoizInjectInterface getLoizInject() {
		return new LoizInject("Abstract Module - val par @Provided");				
	}

}