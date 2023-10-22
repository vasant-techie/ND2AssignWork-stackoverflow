package com.nd2.assignwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Department")
@Getter
@Setter
public class DepartmentEntity {

	@Id
	@Column(name = "Department_ID", columnDefinition = "varchar(20)")
	private String departmentID;
	
	@Column(name = "Department_Name", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String departmentName;
}
