package com.myproject.connections.security.serviceimpl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myproject.connections.entitybeans.CustomerDetails;
import com.myproject.connections.entitybeans.Role;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;

/**
 * @author Shridha S Jalihal
 * UserDetailsService spring-security implementation.
 */
@Service
public class CustomerSecurityServiceImpl implements UserDetailsService{

	@Autowired
	private CustomerServiceImpl customerService;


	/*Method for authentication
	 * @param emailid.
	 * */
	@Override
	public UserDetails loadUserByUsername(String emailid) throws UsernameNotFoundException {
		CustomerDetails  customer = customerService.findByEmailId(emailid);
		List<GrantedAuthority> authorities = getUserAuthority(customer.getRoles());
		return buildUserForAuthentication(customer, authorities);
	}
	
	/*Method to get user authorities
	 * @param Set of userRoles.
	 * @return List of GrantedAuthority
	 * */
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		if(userRoles!=null && userRoles.size()>0) {
			for (Role role : userRoles) {
				roles.add(new SimpleGrantedAuthority(role.getRolename()));
			}
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}


	/*Method to build Spring User bean with the provided credentials	
	 * @param customerDetails
	 * @param List of grantedAuthority
	 * @return Spring bean's UserDetails
	 * */
	private UserDetails buildUserForAuthentication(CustomerDetails customerDetails, List<GrantedAuthority> authorities) {
		return new User(customerDetails.getEmailid(), customerDetails.getPassword(),
				true, true, true, true, authorities);
	}	


}
