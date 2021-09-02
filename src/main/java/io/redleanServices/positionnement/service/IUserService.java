package io.redleanServices.positionnement.service;

import java.util.List;
import java.util.Optional;

import io.redleanServices.positionnement.entity.User;

public interface IUserService {

	User registerNewUser(User user);

	String getEncodedPassword(String password);

	List<User> getUsers();

	void addRoleToUser(String username, String roleName);

	void deleteUser(String id);

	void updateUser(User user);

	User getUserByUserName(String username);

	List<User> findConsultantParKey(String keyword);

}
