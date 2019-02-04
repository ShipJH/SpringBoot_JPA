package com.jpa.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.sample.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}