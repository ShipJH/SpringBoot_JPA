package com.jpa.sample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity(name="users")
@Getter @Setter
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "고유 ID", dataType = "long", position=0)
	private Long id;
	
	@ApiModelProperty(value = "이름", dataType = "String", position=10)
	private String name;
	
	@ApiModelProperty(value = "주소", dataType = "String", position=20)
	private String addr;
	
}
