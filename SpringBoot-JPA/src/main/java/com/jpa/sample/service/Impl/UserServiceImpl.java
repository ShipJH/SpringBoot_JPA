package com.jpa.sample.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Override
	public List<User> findByAddrContains(String addr) {
		List<User> users = userRepository.findByAddrContains(addr);
		return users;
	}

	
	public Page<User> findByAddrContainsPage(String addr, int pageNo) {

		Page<User> users = userRepository.findByAddrContainsOrderByIdDesc(addr, PageRequest.of(pageNo, 3));
		//Page<User> users = userRepository.findByAddrContains(addr, PageRequest.of(0, 10, Sort.by("id").descending()));
		return users;
	}

}
