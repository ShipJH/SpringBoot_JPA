package com.jpa.sample.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "메일 모델")
public class Mail {

	@ApiModelProperty(value = "보내는사람(발신자)", dataType = "String", position=0)
	private String fromAddr;
	
	@ApiModelProperty(value = "받는사람(수신자)", dataType = "String", position=10)
	private String toAddr;
	
	@ApiModelProperty(value = "제목", dataType = "String", position=20)
	private String subject;
	
	@ApiModelProperty(value = "내용", dataType = "String", position=30)
	private String contents;
	
}
