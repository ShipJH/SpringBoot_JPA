package com.jpa.sample.service;

import java.util.List;

import com.jpa.sample.entity.Member;
import com.jpa.sample.entity.Phone;

public interface PMService {
	public void saveMember();
	public List<Phone> print();
	public List<Member> lazyPrint();
	public List<Member> lazyPrint2();
	public void deletAll();
	
	public List<Phone> getJoin();
}
