package com.nd2.assignwork.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table(name = "Task")
public class TaskEntity {

	@Id
	@Column(name = "Task_ID", columnDefinition = "varchar(20)")
	private String taskID;

	@Column(name = "Task_Title", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String taskTitle;

	@Column(name = "Task_Content", columnDefinition = "nvarchar(255)")
	private String taskContent;

	@Column(name = "Task_DateSend", columnDefinition = "datetime")
	@CreationTimestamp
	private Date taskDateSend;

	@Column(name = "Task_DateEnd", columnDefinition = "datetime")
	private Date taskDateEnd;

	@Column(name = "Task_State", columnDefinition = "int default 0")
	private int taskState;

	// Foreign key Task_Category_Task

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Task_Category_ID")
	@NotNull
	private TaskCategoryEntity taskCategory;

	// Foreign key Task_Personal_Send
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Task_Personal_Send")
	@NotNull
	private UserAccountEntity taskPersonalSend;

	// Foreign key Task_Personal_Receive
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Task_Personal_Receive")
	@NotNull
	private UserAccountEntity taskPersonalReceive;

	// Foreign key Discuss_Task
	@OneToMany(mappedBy = "discussTask", cascade = CascadeType.ALL)
	private List<DiscussEntity> Discuss;

	// Foreign key Task_File
	@ManyToMany(mappedBy = "Task")
	private Set<FileEntity> File;
}
