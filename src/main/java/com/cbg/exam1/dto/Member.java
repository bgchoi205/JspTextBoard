package com.cbg.exam1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Member {
	
	private int id;
	private String regDate;
	private String updateDate;
	private String delDate;
    private boolean delStatus;
	private String loginId;
	private String loginPw;
	private String name;
	private String nickName;
	private String email;
	private String cellPhone;
    private int authLevel;
	

}