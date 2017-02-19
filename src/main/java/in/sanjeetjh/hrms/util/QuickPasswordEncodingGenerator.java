/**
 * 
 */
package in.sanjeetjh.hrms.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sanjeet
 *
 */
public class QuickPasswordEncodingGenerator {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String password = "myjava11";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(password));
	}

}
