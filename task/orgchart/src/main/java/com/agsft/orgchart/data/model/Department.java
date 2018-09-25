package com.agsft.orgchart.data.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bpawar
 *
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

	private static final long serialVersionUID = 5189081903999676343L;

	@Id
	private String _id;
	@Indexed(unique = true)
	private String name;
	private long assignedCost;

}
