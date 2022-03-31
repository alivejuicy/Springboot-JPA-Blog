package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
	
	@ManyToOne(fetch = FetchType.EAGER) // Many = Board, User = One , 유저 하나가 많은 게시글을 올릴 수 있는 로직
	@JoinColumn(name="userId")
	private User user; //DB는 Object를 저장할 수 없고, 자바는 가넝
	
	@OneToMany(mappedBy = "board",fetch = FetchType.EAGER)
	private List<Reply> reply;
	
	@CreationTimestamp //현재 시간 담기
	private Timestamp createDate;
	
	
	
	
	
	

}
