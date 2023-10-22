package com.nd2.assignwork.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Permission")
public class PermissionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Permission_ID")
	private Integer permissionID;
	
	@Column(name = "Permission_Name", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String permissionName;
	
	// Foreign key User_Permission
	@ManyToMany(mappedBy = "Permission")
	private Set<UserAccountEntity> User = new HashSet<>();

	public Set<UserAccountEntity> getUser() {
		return User;
	}

	public void setUser(Set<UserAccountEntity> user) {
		User = user;
	}

	public Integer getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(Integer permissionID) {
		this.permissionID = permissionID;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
}
