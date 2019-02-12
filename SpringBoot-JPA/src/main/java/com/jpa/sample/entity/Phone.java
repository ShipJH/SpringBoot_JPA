package com.jpa.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id
	@Column(name="seq")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int seq;

	@Column(name="no")
	private String no;

	@ManyToOne(optional=false)
	@JoinColumn(name="member_id")
	private Member member;

	public Phone() {}
	public Phone(Member member, String no){
		this.no = no;
		this.member = member;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		String result = "[phone_"+seq+"] " + no;
		return result;
	}
	
}
