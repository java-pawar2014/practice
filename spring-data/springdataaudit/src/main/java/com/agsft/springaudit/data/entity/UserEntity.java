package com.agsft.springaudit.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
@Data
@NoArgsConstructor
public class UserEntity {

	@Id
	@Column(updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String firstName;

	private String lastName;

	@Column(unique = true)
	private String email;

	private long contact;

	@Column(unique = true)
	private String username;

	private String password;

	@CreatedBy
	@JsonIgnore
	private String createdBy;

	@LastModifiedBy
	@JsonIgnore
	private String lastModifiedBy;

	@CreatedDate
	@JsonIgnore
	private Date createdDate;

	@LastModifiedDate
	@JsonIgnore
	private Date lastModifiedDate;

}
