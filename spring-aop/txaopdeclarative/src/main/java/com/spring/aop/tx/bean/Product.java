package com.spring.aop.tx.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bpawar
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Product implements Serializable {

	private static final long serialVersionUID = -4645156904854230767L;

	// Default constructor needed for JPA,
	// Invocation of constructor happens through reflection.

	@Id
	private Integer productId;
	private String productName;
}
