package com.jpa.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.sample.entity.Member;
import com.jpa.sample.entity.Team;
import com.jpa.sample.service.Impl.TeamServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "팀관리", value = "팀관리", description = "팀관리")
public class TeamTestController {

	@Autowired
	private TeamServiceImpl teamServiceImpl; 
	
	@ApiOperation(value = "모든 팀보기")
	@GetMapping(value="/allTeam")
	public ResponseEntity<List<Team>> findByAllTeam(){
		
		List<Team> teams = teamServiceImpl.findAll();
		
		
		
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}
	
	@ApiOperation(value = "팀 등록하기")
	@PostMapping(value="/saveTeam")
	public ResponseEntity<Team> saveTeam(Team team){
		
		Team resultTeam = teamServiceImpl.save(team);
		
		if(resultTeam == null) {
			return new ResponseEntity<Team>(resultTeam, HttpStatus.OK);
		}

		return new ResponseEntity<Team>(resultTeam, HttpStatus.OK);
	}
	
	
	
	@ApiOperation(value = "모든 팀원 목록보기")
	@GetMapping(value="/allTeamUser")
	public ResponseEntity<List<Member>> findByAllTeamUser(){
		
		List<Member> teams = teamServiceImpl.findAllUsers();
		
		
		
		return new ResponseEntity<List<Member>>(teams, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "팀원 등록하기")
	@PostMapping(value="/saveMember")
	public ResponseEntity<Member> saveTeamUser(Member Member){
		
		Member resultMember = teamServiceImpl.saveMember(Member);
		
		if(resultMember == null) {
			return new ResponseEntity<Member>(resultMember, HttpStatus.OK);
		}
		return new ResponseEntity<Member>(resultMember, HttpStatus.OK);
	}	
}
