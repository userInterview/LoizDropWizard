package org.tms.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import org.tms.dto.UserDTO;
import org.tms.pojo.User;

import org.apache.commons.beanutils.BeanUtils;

public final class CommonHelper {


	public static List<UserDTO> convertToListDto(List<User> lUsers) {
		List<UserDTO> listDto  = lUsers.stream()
		        .map(
		        			user -> new UserDTO(user.getId(),user.getName())
		        	)
		        .collect(Collectors.toList());

		return listDto ;
	}
	
	
	public static User convertToModel(UserDTO userDTO) throws IllegalAccessException, InvocationTargetException {
		
		User user = new User(); 
		BeanUtils.copyProperties(user, userDTO);
		return user ;
	}

}