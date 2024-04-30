package com.esha.StudentFestDetails.StudentFestDetails.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.esha.StudentFestDetails.StudentFestDetails.entity.Role;
import com.esha.StudentFestDetails.StudentFestDetails.entity.User;

public class UserDecorator implements UserDetails {
	
	User user;
	public UserDecorator(User user) {
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles =user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for(Role role:roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities ;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		LocalDate accExpiryDate=user.getAccountExpiryDate(); 
		LocalDate todaysDate=LocalDate.now();				
		if(accExpiryDate.isAfter(todaysDate))
			return true;
		else
			return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getAccountLockedStatus()==1?true:false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getCredentialsExpiryDate().isAfter(LocalDate.now())? true: false;
	}

	@Override
	public boolean isEnabled() {
		int enabledStatus=user.getAccountEnableStatus();
		if(enabledStatus==1)
			return true;
		else
			return false;
	}

}
