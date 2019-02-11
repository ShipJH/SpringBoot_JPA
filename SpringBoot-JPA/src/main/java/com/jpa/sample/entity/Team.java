package com.jpa.sample.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class Team {
	
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;
	
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "TEAM_ID")
	private List<Member> members = new ArrayList<Member>();
	
}
