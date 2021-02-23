package com.dropwizard.introduction.resource;

import com.dropwizard.introduction.dao.guicemodules.LoizInjectInterface;
import com.dropwizard.introduction.dao.providers.LoizInjectServiceProvider;
import com.dropwizard.introduction.domain.Brand;
import com.dropwizard.introduction.repositories.BrandDAO;
 
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/brands")
@Singleton
public class BrandResource {	
	  
	
//	private final BrandDAO brandDAO;
//	
//
//    public BrandResource(BrandDAO brandDAO) {
//        this.brandDAO = brandDAO;
//    }
//    
//
//	@GET
//	@Path("/all")
//	public List<Brand> getBrands() {
//		System.out.println("ligne de debuggage");
//		return brandDAO.findAll();
//	}	
	
	
    @Inject
    Provider<LoizInjectServiceProvider>  attrloizInjectServiceProvider ;
    
	@GET
	@Path("/loiz")
	@Produces(MediaType.APPLICATION_JSON)
	public LoizInjectInterface getLoizGuiceProvidedInjection() {
		LoizInjectServiceProvider loizInjectServiceProvider = attrloizInjectServiceProvider.get() ;
		LoizInjectInterface loizInjectInterface  = loizInjectServiceProvider.get() ;
		return loizInjectInterface ;
	}  

}
