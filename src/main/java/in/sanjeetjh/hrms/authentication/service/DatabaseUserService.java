/**
 * 
 */
package in.sanjeetjh.hrms.authentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sanjeetjh.hrms.authentication.entity.User;
import in.sanjeetjh.hrms.authentication.repository.UserRepository;

/**
 * @author sanjeet
 *
 */
@Service
public class DatabaseUserService implements UserService {
	private final UserRepository userRepository;

	@Autowired
	public DatabaseUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.sanjeetjh.hrms.authentication.service.UserService#getByUsername(java.
	 * lang.String)
	 */
	@Override
	public Optional<User> getByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

}
