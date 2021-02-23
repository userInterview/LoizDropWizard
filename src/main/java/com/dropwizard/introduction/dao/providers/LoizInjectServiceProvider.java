package com.dropwizard.introduction.dao.providers;

import javax.inject.Provider;
import com.dropwizard.introduction.dao.guicemodules.LoizInject;
import com.dropwizard.introduction.dao.guicemodules.LoizInjectInterface;



public class LoizInjectServiceProvider implements Provider<LoizInjectInterface> {
	
    @Override
    public LoizInjectInterface get() {
         return (new LoizInject("NomExmpleProvider")) ;
    }
}