package org.tms.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tms.dao.datamodel.UserPojo;
import org.tms.dao.providers.UserDaoProvider;
import org.tms.domain.User;

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
		attrUserDaoProvider.get().clearTableFullNames() ;
		for (int i = 0 ; i <= nbEntries ; i++) {
			String strFulname = "nom" + i + " prenom " + i ;			
			attrUserDaoProvider.get().createFullNames(strFulname);
			//logger.info("insertion de {}",strFulname);
		}
		return getAllFullNames() ;
	}
}
