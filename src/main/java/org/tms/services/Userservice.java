package org.tms.services;

import java.util.List;

import org.tms.pojo.User;

public interface Userservice {

	public List<User> getAllFullNames();

	public void deleteAllFullNames();

	public List<User> createFullNames(int nbEntries);

	public void updateFullName(User user);
	
}
