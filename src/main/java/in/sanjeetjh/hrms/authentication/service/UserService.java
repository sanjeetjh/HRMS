package in.sanjeetjh.hrms.authentication.service;

import java.util.Optional;

import in.sanjeetjh.hrms.authentication.entity.User;


/**
 * 
 * @author vladimir.stankovic
 *
 * Aug 17, 2016
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
}
