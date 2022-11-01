package com.exe.Mchet.board.domain;

import java.util.Date;

import lombok.*;

@NoArgsConstructor
//@AllArgsConstructor 
@Getter
@Setter
@ToString
public class BoardVO {
	
	private int idx;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	private int cnt;


}