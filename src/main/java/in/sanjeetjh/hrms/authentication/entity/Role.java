package in.sanjeetjh.hrms.authentication.entity;

/**
 * Enumerated {@link User} roles.
 * 
 * @author vladimir.stankovic
 *
 * Aug 16, 2016
 */
public enum Role {
    ADMIN, EMP;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
