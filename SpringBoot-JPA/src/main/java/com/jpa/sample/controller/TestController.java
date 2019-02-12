package com.jpa.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.sample.entity.Member;
import com.jpa.sample.entity.Phone;
import com.jpa.sample.service.Impl.PMServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "테스트 컨트롤러", value = "테스트 컨트롤러", description = "테스트 컨트롤러")
public class TestController {

	@Autowired
	private PMServiceImpl pmServiceImpl;
	
//	@ApiOperation(value = "팀 등록하기")
//	@PostMapping(value="/saveStudyAndAccount")
//	public ResponseEntity<Account> saveStudyAndAccount(){
//		
//		Account result = studyServiceImpl.saveStudyAndAccount();
//		
//		if(result == null) {
//			return new ResponseEntity<Account>(result, HttpStatus.OK);
//		}
//		return new ResponseEntity<Account>(result, HttpStatus.OK);
//	}
	
	
	@ApiOperation(value = "멤버 등록하기")
	@PostMapping(value = "/saveMember")
	public ResponseEntity<String> saveMember(){
		
		try {
			pmServiceImpl.saveMember();	
		}catch (Exception e) {
			return new ResponseEntity<String>("error", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "EAGER 조회하기")
	@GetMapping(value = "/printMember")
	public ResponseEntity<String> printMember(){
		
		List<Phone> phones = pmServiceImpl.print();
		
		return new ResponseEntity<String>("d", HttpStatus.OK);
	}	
	
	
	@ApiOperation(value = "LAZY 조회하기")
	@GetMapping(value = "/lazyPrintMember")
	public ResponseEntity<String> lazyPrintMember(){
		
		List<Member> member = pmServiceImpl.lazyPrint();
		
		return new ResponseEntity<String>("d", HttpStatus.OK);
	}	
	
	
	@ApiOperation(value = "LAZY2 조회하기")
	@GetMapping(value = "/lazy2PrintMember")
	public ResponseEntity<String> lazy2PrintMember(){
		
		List<Member> member = pmServiceImpl.lazyPrint2();
		
		return new ResponseEntity<String>("d", HttpStatus.OK);
	}	
	
	
	@ApiOperation(value = "데이터 삭제하기")
	@DeleteMapping(value = "/memberDelAll")
	public ResponseEntity<String> memberDelAll(){
		
		pmServiceImpl.deletAll();
		
		return new ResponseEntity<String>("OK~", HttpStatus.OK);
	}	
	
	@ApiOperation(value = "조인 한 값 가져오기")
	@GetMapping
	public ResponseEntity<String> selectJoin(){
		
		
		
		return new ResponseEntity<String>("OK~", HttpStatus.OK);
	}	
	
	
	
	
	
	
	
}
