package com.jpa.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.sample.entity.Member;
import com.jpa.sample.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
