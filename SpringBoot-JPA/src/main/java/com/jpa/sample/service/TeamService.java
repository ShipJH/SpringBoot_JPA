package com.jpa.sample.service;

import java.util.List;

import com.jpa.sample.entity.Member;
import com.jpa.sample.entity.Team;

public interface TeamService {
	public List<Team> findAll();
	public Team save(Team team);
	public Member saveMember(Member member);
	public List<Member> findAllUsers();
}
