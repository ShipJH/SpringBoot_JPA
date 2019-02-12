package com.jpa.sample.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.sample.entity.Member;
import com.jpa.sample.entity.Phone;
import com.jpa.sample.repository.MemberRepository;
import com.jpa.sample.repository.PhoneRepository;
import com.jpa.sample.service.PMService;

@Service
public class PMServiceImpl implements PMService{

	@Autowired
	private MemberRepository mr;

	@Autowired
	private PhoneRepository pr;

	public void saveMember(){
		Member first = new Member("bae");
		Member second = new Member("hwang");
		Member third = new Member("park");

		Phone p = new Phone(first, "010-5500-2890");

		mr.save(first);
		mr.save(second);
		mr.save(third);

		pr.save(p);
	}

	public List<Phone> print(){
		// @ManyToOne의 fetch 기본전략은 EAGER이다.
		// 따라서 @Transactional 어노테이션이 없더라도
		// 기본적으로 전부 데이터를 적재한다.
		List<Phone> phone = pr.findAll();
		for( Phone p : phone ){
			System.out.println(p.toString()+ " " + p.getMember().toString());
			
		}
		
		
		return phone;
	}

	@Transactional
	public List<Member> lazyPrint(){
		// @OneToMany의 fetch 기본전략은 LAZY이다.
		// 따라서 Member Entity 내부의 Phone 콜렉션은
		// LAZY 전략이기 때문에 @Transactional 어노테이션이 있어야 한다.
		List<Member> member = mr.findAll();
		for( Member m : member ) {
			System.out.println(m.toString());
			for( Phone e : m.getPhone() ){
				System.out.println(e.toString());
			}
		}
		
		return member;
	}

	public List<Member> lazyPrint2(){
		// Entity가 LAZY 전략일지라도
		// LAZY 전략을 쓰는 객체를 사용하지 않는다면
		// @Transactional 어노테이션이 없어도 된다.
		List<Member> member = mr.findAll();
		for( Member m : member ) {
			System.out.println(m.toString());
		}
		
		return member;
	}

	public void deletAll() {
		mr.deleteAll();
		pr.deleteAll();
	}
}
