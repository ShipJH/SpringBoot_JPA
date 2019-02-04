package com.jpa.sample.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.sample.entity.User;
import com.jpa.sample.repository.UserRepository;
import com.jpa.sample.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User save(User user) {
		User resultUser = userRepository.save(user);
		return resultUser;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		User user = new User();
		user.setId(id);
		userRepository.delete(user);
	}

}
