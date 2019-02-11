package com.jpa.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.sample.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
