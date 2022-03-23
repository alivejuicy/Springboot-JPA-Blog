package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length=100)
	private String title;
	
	@Lob//대용량 데이터를 관리하기 위해서? : 영속성 관련 어노테이션
	private String content;
	
	@ColumnDefault("0") //조회수 관리 어노테이션
	private int count;
	
	@ManyToOne // Many = Board, User = One , 유저 하나가 많은 게시글을 올릴 수 있는 로직
	@JoinColumn(name="userId")
	private User user; //DB는 Object를 저장할 수 없고, 자바는 가넝
	
	@CreationTimestamp //현재 시간 담기
	private Timestamp createDate;
	
	
	
	
	
	

}
