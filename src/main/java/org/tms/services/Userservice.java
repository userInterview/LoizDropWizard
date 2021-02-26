package org.tms.services;

import java.util.List;

import org.tms.domain.User;

public interface Userservice {

	public List<User> getAllFullNames();

	List<User> createFullNames(int nbEntries);

	void deleteAllFullNames();

}
