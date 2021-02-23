package com.dropwizard.introduction.resource;

import com.dropwizard.introduction.dao.guicemodules.LoizInjectInterface;
import com.dropwizard.introduction.dao.providers.BrandDaoProvider;
import com.dropwizard.introduction.dao.providers.LoizInjectServiceProvider;
import com.dropwizard.introduction.domain.Brand;
import com.dropwizard.introduction.repositories.BrandDAO;
import com.google.inject.name.Named;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class BrandResource {
	
	@Inject
	BrandDaoProvider attrBrandDaoProvider ;	
	
	@GET
	@Path("/jdbi-injected-provided")
	public List<Brand> getBrandsProvidedInjection() {
		System.out.println("endpoint /jdbi-injected-provided");
		return attrBrandDaoProvider.get().findAll();
	}
	
	@Inject
	@Named("loizBindedNamed")	
	LoizInjectInterface loizGuiceBindedNamed ;
	
	@GET
	@Path("/loiz-guice-binded-named")
	@Produces(MediaType.APPLICATION_JSON)
	public LoizInjectInterface getLoizGuicedProvided() {
		System.out.println("endpoint /loiz-guice-provided");
		return loizGuiceBindedNamed ;
	} 	
	
	@Inject
	LoizInjectInterface loizGuiceProvided ;
	
	@GET
	@Path("/loiz-guiced-provided")
	@Produces(MediaType.APPLICATION_JSON)
	public LoizInjectInterface getLoizGuiceSmpleInjection() {
		System.out.println("endpoint /loiz-provided-guice");
		return loizGuiceProvided ;
	}	
	
    @Inject
    Provider<LoizInjectServiceProvider>  attrloizProvidedOnly ;
    
	@GET
	@Path("/provided-only")
	@Produces(MediaType.APPLICATION_JSON)
	public LoizInjectInterface getLoizGuiceProvidedInjection() {
		System.out.println("ligne getBrands");
		LoizInjectServiceProvider loizInjectServiceProvider = attrloizProvidedOnly.get() ;
		LoizInjectInterface loizInjectInterface  = loizInjectServiceProvider.get() ;
		return loizInjectInterface ;
	}  

}
