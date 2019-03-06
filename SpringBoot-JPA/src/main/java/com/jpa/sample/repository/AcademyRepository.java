package com.jpa.sample.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.sample.entity.Academy;

public interface AcademyRepository extends JpaRepository<Academy, Long> {

}
