package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.User;

public interface IUserService {

	User registerNewUser(User user);

	String getEncodedPassword(String password);

	List<User> getUsers();

	void addRoleToUser(String username, String roleName);

}
