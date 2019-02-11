package com.jpa.sample.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.sample.entity.Member;
import com.jpa.sample.entity.Team;
import com.jpa.sample.repository.MemberRepository;
import com.jpa.sample.repository.TeamRepository;
import com.jpa.sample.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{

	
	@Autowired TeamRepository teamRepository;
	
	@Autowired MemberRepository memberRepository;
	
	@Override
	public List<Team> findAll() {
		
		return teamRepository.findAll();
	}

	@Override
	public Team save(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Member saveMember(Member member) {
		
		
		Member member2 = new Member();
//		member2.setTeam(team);
		member2.setUsername(member.getUsername());
		
		Team team = new Team();
		team.setId(1l);
		teamRepository.findById(team.getId());
		
		
		team.getMembers().add(member);
		

		
		return memberRepository.save(member2);
	}

	@Override
	public List<Member> findAllUsers() {
		return memberRepository.findAll();
	}

	
}
