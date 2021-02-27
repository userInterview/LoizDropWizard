package org.tms.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.name.Named;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.tms.dao.guicemodules.LoizInjectInterface;
import org.tms.dao.providers.UserDaoProvider;
import org.tms.dao.providers.LoizInjectServiceProvider;
import org.tms.domain.User;
import org.tms.services.Userservice;

//import org.apache.logging.log4j.Logger;  Logger logger = LogManager.getLogger(Hello.class);

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class UserResource {

	private static Logger logger = LoggerFactory.getLogger(UserResource.class);

	@Inject
	Userservice userservice;

	@GET
	@Path("/jdbi-injected-provided-read")
	public List<User> getUsersProvidedInjection() {
		logger.info("endpoint /jdbi-injected-provided");
		return userservice.getAllFullNames();
	}

	
	@POST
	@Path("/jdbi-injected-provided-create/{nbfullnames}")
	@Timed
	public List<User> createUsersProvidedInjection(@PathParam(value = "nbfullnames") int nbFullNames) {
		logger.info("endpoint /jdbi-injected-provided-create/{nbfullnames}");
		return userservice.createFullNames(nbFullNames);
	}

	@DELETE
	@Path("/jdbi-injected-provided-clearallusers")
	public Response deleteAllFullnames() {
		userservice.deleteAllFullNames();
		return Response.ok().build();
	}

	@Inject
	@Named("loiznamed")
	LoizInjectInterface loizGuiceBindedNamed;

	@GET
	@Path("/loiz-guice-binded-named")
	@Produces(MediaType.APPLICATION_JSON)
	public LoizInjectInterface getLoizGuicedProvided() {
		logger.info("endpoint /loiz-guice-provided");
		return loizGuiceBindedNamed;
	}

	@Inject
	LoizInjectInterface loizGuiceProvided;

	@GET
	@Path("/loiz-guiced-provided")
	@Produces(MediaType.APPLICATION_JSON)
	public LoizInjectInterface getLoizGuiceSmpleInjection() {
		logger.info("endpoint /loiz-provided-guice");
		return loizGuiceProvided;
	}

	@Inject
	Provider<LoizInjectServiceProvider> attrloizProvidedOnly;

	@GET
	@Path("/provided-only")
	@Produces(MediaType.APPLICATION_JSON)
	@Timed
	public LoizInjectInterface getLoizGuiceProvidedInjection() {
		logger.info("ligne /provided-only");
		LoizInjectServiceProvider loizInjectServiceProvider = attrloizProvidedOnly.get();
		LoizInjectInterface loizInjectInterface = loizInjectServiceProvider.get();
		return loizInjectInterface;
	}

}
