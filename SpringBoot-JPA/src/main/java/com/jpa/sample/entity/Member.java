package com.jpa.sample.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {

	
	@Id
	@Column(name="seq")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int seq;

	@Column(name="name")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="member")
	private List<Phone> phone;
	
	//생성자
	public Member(){}
	public Member(String name){
		this.name = name;
	}
	


	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//List get 없을때, new 객체생성
	public List<Phone> getPhone() {
		if( phone == null) {
			phone = new ArrayList<Phone>();
		}
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	
	
	public void addPhone(Phone p){
		List<Phone> phone = getPhone();
		phone.add(p);
	}
	
	@Override
	public String toString() {
		String result = "[member_"+seq+"] " + name;
		return result;
	}
}
