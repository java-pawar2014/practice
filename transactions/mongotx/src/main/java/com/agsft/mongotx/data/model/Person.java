package com.agsft.mongotx.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bpawar
 *
 */
// @Document
@Entity
@Table(name = "tbl_person", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

	private static final long serialVersionUID = 5696986059554824460L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String contact;
	// @Indexed(unique = true)
	private String email;
	private String city;
	@JsonFormat(pattern = "MM-dd-yyyy")
	@Column(name = "birth_date")
	private Date birthDate;

}
