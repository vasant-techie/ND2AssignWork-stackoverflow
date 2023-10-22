package com.nd2.assignwork.dto;

import java.util.ArrayList;
import java.util.List;

public class UserAccountDTO {
	
	private String userID;
	private String userUserName;
	private String userFullName;
	private String userPassword;
	private String userPhone;
	private String userEmail;
	private String userPosition;
	private String userDepartment;
	private byte[] userImage;
	private Boolean userIsActive;
	
	private List<String> permissionName = new ArrayList<>();
	private List<String> documentReceive = new ArrayList<>();
	
	public String getUserUserName() {
		return userUserName;
	}

	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public Boolean getUserIsActive() {
		return userIsActive;
	}

	public void setUserIsActive(Boolean userIsActive) {
		this.userIsActive = userIsActive;
	}

	public List<String> getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(List<String> permissionName) {
		this.permissionName = permissionName;
	}

	public List<String> getDocumentReceive() {
		return documentReceive;
	}

	public void setDocumentReceive(List<String> documentReceive) {
		this.documentReceive = documentReceive;
	}
}
