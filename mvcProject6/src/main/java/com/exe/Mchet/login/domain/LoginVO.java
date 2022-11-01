package com.exe.Mchet.login.domain;

import java.util.Date;

import lombok.*;


@NoArgsConstructor
//@AllArgsConstructor 
@Getter
@Setter
@ToString

public class LoginVO {
	private int num;
	private String id;
	private String pw;
	private String email;
	private String name;
	private String pnum;
	private int seq;
	private Date createdData;
	private int userLevel;	
}