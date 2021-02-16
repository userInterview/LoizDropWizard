package com.dropwizard.introduction.dao.guicemodules;

import com.dropwizard.introduction.dao.datamodel.LoizInject;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class LoizInjectGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    public LoizInject getGreeter(){
        return new LoizInject("NomExemple");
    }
}