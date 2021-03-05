package org.tms.resource;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.name.Named;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.tms.dao.guicemodules.LoizInjectInterface;
import org.tms.dao.providers.LoizInjectServiceProvider;
import org.tms.dto.UserDTO;
import org.tms.helper.CommonHelper;
import org.tms.pojo.User;
import org.tms.services.Userservice;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

//import org.apache.logging.log4j.Logger;  Logger logger = LogManager.getLogger(Hello.class);

import java.util.List;
import java.util.stream.Collectors;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class UserResource {

	private static Logger logger = LoggerFactory.getLogger(UserResource.class);

	@Inject
	Userservice userservice;

	@GET
	@Path("/jdbi-injected-provided-read")
	public List<UserDTO> getUsersProvidedInjection() {
		logger.info("endpoint /jdbi-injected-provided");
		List<User> lUsers = userservice.getAllFullNames();
		return CommonHelper.convertToListDto(lUsers) ;		
	}	
	
	@POST
	@Path("/jdbi-injected-provided-create/{nbfullnames}")
	@Timed
	public List<User> initUserFullNamesProvidedInjection(@PathParam(value = "nbfullnames") int nbFullNames) {
		logger.info("endpoint /jdbi-injected-provided-create/{nbfullnames}");
		return userservice.createFullNames(nbFullNames);
	}

	@DELETE
	@Path("/jdbi-injected-provided-clearallusers")
	public Response deleteAllFullnames() {
		userservice.deleteAllFullNames();
		return Response.ok().build();
	}
	
	@PUT
	@Path("/jdbi-injected-provided-updateuser")	
	public Response updateFullName(@Valid UserDTO userDTO) throws IllegalAccessException, InvocationTargetException {		
		User user = CommonHelper.convertToModel(userDTO) ;
		userservice.updateFullName(user);
		return Response.ok().build();
	}
	
	@Inject
	@Named("loiznamed")
	LoizInjectInterface loizGuiceBindedNamed;

	@GET
	@Path("/loiz-guice-binded-named")
	public LoizInjectInterface getLoizGuicedProvided() {
		logger.info("endpoint /loiz-guice-provided");
		return loizGuiceBindedNamed;
	}

	@Inject
	LoizInjectInterface loizGuiceProvided;

	@GET
	@Path("/loiz-guiced-provided")
	public LoizInjectInterface getLoizGuiceSmpleInjection() {
		logger.info("endpoint /loiz-provided-guice");
		return loizGuiceProvided;
	}

	@Inject
	Provider<LoizInjectServiceProvider> attrloizProvidedOnly;

	@GET
	@Path("/provided-only")
	@Timed
	public LoizInjectInterface getLoizGuiceProvidedInjection() {
		logger.info("ligne /provided-only");
		LoizInjectServiceProvider loizInjectServiceProvider = attrloizProvidedOnly.get();
		LoizInjectInterface loizInjectInterface = loizInjectServiceProvider.get();
		return loizInjectInterface;
	}

}
