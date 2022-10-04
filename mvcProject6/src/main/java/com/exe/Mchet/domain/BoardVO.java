package com.exe.Mchet.domain;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@ToString
//@AllArgsConstructor 
public class BoardVO {
	private int idx;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	private int cnt;

}