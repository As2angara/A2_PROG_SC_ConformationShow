package ca.sheridancollege;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.dao.DAOSec;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			DAOSec dao = new DAOSec();

	       ca.sheridancollege.bean.User user = dao.findUserAccount(username);
	       
	        if (user == null) {
	            System.out.println("User not found! " + username);
	            throw new UsernameNotFoundException("User " + username + " was not found in the database");
	        }
	 
	        System.out.println("Found User: " + user);
	 
	        // [ROLE_USER, ROLE_ADMIN,..]
	        ArrayList<String> roleNames = dao.getRoleNames(user.getUserId());
	 
	        System.out.println(roleNames);
	        
	        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
	        if (roleNames != null) {
	            for (String role : roleNames) {
	                // ROLE_USER, ROLE_ADMIN,..
	                GrantedAuthority authority = new SimpleGrantedAuthority(role);
	                grantList.add(authority);
	            }
	        }
	 
	        UserDetails userDetails = (UserDetails) new User(user.getUserName(), //
	                user.getEncryptedPassword(), grantList);
	 
	        return userDetails;	
	}

}

