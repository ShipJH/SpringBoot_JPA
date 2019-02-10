package com.jpa.sample.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jpa.sample.entity.User;

public interface UserService {

	public List<User> getAllUsers();	
	
	public User save(User user);
	
	public void delete(Long id);
	
	public List<User> findByAddrContains(String addr);
	
	public Page<User> findByAddrContainsPage(String addr, int pageNo);
}
