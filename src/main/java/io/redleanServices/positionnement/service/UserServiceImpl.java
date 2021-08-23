package io.redleanServices.positionnement.service;
import io.redleanServices.positionnement.dao.RoleDao;
import io.redleanServices.positionnement.dao.UserDao;
import io.redleanServices.positionnement.entity.Role;
import io.redleanServices.positionnement.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;
    
    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Super_Admin");
        // adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("Admin");
        // userRole.setRoleDescription("Default role");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("superAdmin123");
        adminUser.setUserPassword(getEncodedPassword("superAdmin@pass"));
        adminUser.setUserFirstName("super");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserName("raj123");
        user.setUserPassword(getEncodedPassword("raj@123"));
        user.setUserFirstName("raj");
        user.setUserLastName("sharma");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }
	@Override
    public User registerNewUser(User user) {
        Role role = roleDao.findById("Admin").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }
	@Override
    public String getEncodedPassword(String password) {
		
        return passwordEncoder.encode(password);
    }
	@Override
    public List<User> getUsers() {
		 return userDao.findAll();
	}
	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userDao.findByUserName(username);
		Role role = roleDao.findByRoleName(roleName);
		user.getRole().add(role);
		
		userDao.save(user);
		
	}
	@Override
	public void deleteUser(String username) {
		this.deleteUserRole(username);
		userDao.deleteById(username);
	}
	public void deleteUserRole(String username) {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setUrl(url);
	        dataSource.setUsername(userName);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("DELETE FROM `user_role` WHERE user_id = '"+ username +"'");
	} 
	@Override
	public void updateUser(User user) {

		Role role = roleDao.findById("Admin").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        
		userDao.save(user);
		
	}
}