package com.nd2.assignwork.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table(name = "UserAccount")
public class UserAccountEntity {

	@Id
	@Column(name = "User_ID", columnDefinition = "varchar(20)")
	private String userID;

	@Column(name = "User_UserName", columnDefinition = "varchar(30)")
	@NotBlank
	private String userUserName;

	@Column(name = "User_FullName", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String userFullName;

	@Column(name = "User_Password", columnDefinition = "varchar(255)")
	@NotBlank
	private String userPassword;

	@Column(name = "User_Phone", columnDefinition = "varchar(12)")
	@NotBlank
	private String userPhone;

	@Column(name = "User_Email", columnDefinition = "varchar(255)")
	@NotBlank
	private String userEmail;

	@Column(name = "User_Image", columnDefinition = "varbinary(60000)")
	private byte[] userImage;

	@Column(name = "User_isActive", columnDefinition = "bit default 1")
	private Boolean userIsActive;

	// Foreign key User_Position
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Position")
	@NotNull
	private PositionEntity userPosition;

	// Foreign key Task_Personal_Send
	@OneToMany(mappedBy = "taskPersonalSend", cascade = CascadeType.ALL)
	private List<TaskEntity> taskPersonalSend;// = new ArrayList<>();

	// Foreign key Task_Personal_Receive
	@OneToMany(mappedBy = "taskPersonalReceive", cascade = CascadeType.ALL)
	private List<TaskEntity> taskPersonalReceive;// = new ArrayList<>();

	// Foreign key Discuss_User
	@OneToMany(mappedBy = "discussUser", cascade = CascadeType.ALL)
	private List<DiscussEntity> discussUser;// = new ArrayList<>();

	// Foreign key User_Permission
	@ManyToMany
	@JoinTable(name = "User_Permission", joinColumns = @JoinColumn(name = "User_ID"), inverseJoinColumns = @JoinColumn(name = "Permission_ID"))
	private Set<PermissionEntity> Permission = new HashSet<>();

	// Foreign key Document_Incoming_UserSend
	@OneToMany(mappedBy = "documentIncomingUserSend")
	private List<DocumentIncomingEntity> documentIncomingUserSend = new ArrayList<>();

	// Foreign key Document_Incomming_UserReceive
	@OneToMany(mappedBy = "documentIncomingUserReceive")
	private List<DocumentIncomingEntity> documentIncomingUserReceive = new ArrayList<>();

	// Foreign key Document_Send_UserSend
	@OneToMany(mappedBy = "documentSendUserSend")
	private List<DocumentSendEntity> documentSendUserSend = new ArrayList<>();

	// Foreign key User_Receive_Document
	@ManyToMany
	@JoinTable(name = "User_Receive_Document", joinColumns = @JoinColumn(name = "User_ID"), inverseJoinColumns = @JoinColumn(name = "Document_Send_ID"))
	private Set<DocumentSendEntity> documentSend = new HashSet<>();
}
