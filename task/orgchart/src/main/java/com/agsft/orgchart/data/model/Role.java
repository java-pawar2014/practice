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
public class Role implements Serializable {

	private static final long serialVersionUID = 3084842242202609778L;

	@Id
	private String _id;
	@Indexed(unique = true)
	private String name;

}
