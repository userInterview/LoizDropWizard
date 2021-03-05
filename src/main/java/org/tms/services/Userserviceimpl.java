package org.tms.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tms.dao.providers.UserDaoProvider;
import org.tms.pojo.User;

@Singleton
public class Userserviceimpl implements Userservice {	

	private static Logger logger = LoggerFactory.getLogger(Userserviceimpl.class);
	
	@Inject
	UserDaoProvider attrUserDaoProvider ;

	@Override
	public List<User> getAllFullNames() {
		//logger.info("endpoint /jdbi-injected-provided");
		return attrUserDaoProvider.get().findAll();
	}
	
	@Override
	public void deleteAllFullNames() {
		//logger.info("endpoint /jdbi-injected-provided");
		attrUserDaoProvider.get().clearTableFullNames();		
	}

	@Override
	public List<User> createFullNames(int nbEntries) {
		return attrUserDaoProvider.get().clearAndCreateEntries(nbEntries);
	}
	
	@Override
	public void updateFullName(User user) {
		attrUserDaoProvider.get().updateFullName(user);	
	}
}
