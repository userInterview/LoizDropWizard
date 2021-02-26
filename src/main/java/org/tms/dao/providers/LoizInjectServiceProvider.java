package org.tms.dao.providers;

import javax.inject.Provider;
import org.tms.dao.guicemodules.LoizInject;
import org.tms.dao.guicemodules.LoizInjectInterface;

public class LoizInjectServiceProvider implements Provider<LoizInjectInterface> {
	
    @Override
    public LoizInjectInterface get() {
         return (new LoizInject("Val par Provider obtenu grace à autoconfig")) ;
    }
}