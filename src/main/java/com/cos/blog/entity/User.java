package com.cos.blog.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //project에서 연결된 데이터베이스릐 넘버링 전략을 따른다.
	private int id; //auto_increment
	
	@Column(nullable=false, length=30, unique = true)
	private String username;
	
	@Column(nullable=false, length=100) //해쉬 (패스워드 암호화)
	private String password;
	
	@Column(nullable=false, length=50)
	private String email;
	
	//@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role; 
	
	@CreationTimestamp
	private Timestamp createDate;
}
