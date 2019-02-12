package com.jpa.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.sample.entity.Member;
import com.jpa.sample.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

	@Query("SELECT p FROM Phone p WHERE p.seq = 28 ")
	List<Phone> getJoin();

}
