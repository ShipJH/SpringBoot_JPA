package com.jpa.sample.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.sample.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByAddrContains(String addr);
	Page<User> findByAddrContainsOrderByIdDesc(String addr, Pageable pageable);
}
