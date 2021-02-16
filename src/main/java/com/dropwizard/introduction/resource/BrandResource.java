package com.dropwizard.introduction.resource;

import com.dropwizard.introduction.dao.datamodel.LoizInject;
import com.dropwizard.introduction.domain.Brand;
import com.dropwizard.introduction.repositories.BrandDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class BrandResource {

	
    @Inject
    LoizInject loizInject ;
	
	@Inject
	private BrandDAO brandDAO;

    public BrandResource(BrandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }

	@GET
	@Path("/all")
	public List<Brand> getBrands() {
		System.out.println("ligne de debuggage");
		//System.out.println(loizInject.getName());
		return brandDAO.findAll();
	}
	
	@GET
	@Path("/name")
	public String getGuiceInjectName() {
		String strName = loizInject.getName() ;
		return strName ;
	}
	
}
