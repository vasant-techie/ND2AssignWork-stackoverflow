package com.nd2.assignwork.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Position")
public class PositionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Position_ID")
	private Integer positionID;
	
	@Column(name = "Position_Name", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String positionName;
	
	// Foreign key User_Position
	@OneToMany(mappedBy = "userPosition")
	private List<UserAccountEntity> User = new ArrayList<>();
	
	public Integer getPositionID() {
		return positionID;
	}

	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public List<UserAccountEntity> getUser() {
		return User;
	}

	public void setUser(List<UserAccountEntity> user) {
		User = user;
	}
}
